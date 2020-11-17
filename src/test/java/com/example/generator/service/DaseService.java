package com.example.generator.service;

import com.example.generator.dao.BaseDao;
import com.example.generator.entity.FieldBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author panzhi
 * @Description
 * @since 2020-11-09
 */
public class DaseService extends BaseDao {

    public DaseService(Map<String, Object> dbData) {
        super(dbData);
    }

    /**
     * 获取数据库表对应的信息
     * @param templateData
     */
    public void getAllColumns(Map<String, Object> templateData) {
        String databaseName = templateData.get("databaseName").toString();
        String tableName = templateData.get("tableName").toString();
        List<FieldBean> columnList = new ArrayList<FieldBean>();
        getNameAndTypeAndDesc(columnList, databaseName, tableName);
        getTableDesc(templateData, databaseName, tableName);
        templateData.put("columns",columnList);
    }

    /**
     * 获取表字段名称和类型
     * @param columnList
     * @param databaseName
     * @param tableName
     */
    private void getNameAndTypeAndDesc(List<FieldBean> columnList, String databaseName, String tableName){
        //获取数据源连接
        Connection conn = super.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT column_name, data_type, column_comment FROM information_schema.columns WHERE table_schema = '"+databaseName+"' AND table_name = '"+tableName+"'";
            ps =conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                //数据库字段名、类型、描述
                String columnName = rs.getString(1);
                String columnType = rs.getString(2).toUpperCase();
                String columnDsc = rs.getString(3);

                FieldBean fieldBean = new FieldBean().setFieldName(columnName);
                if(columnType.indexOf(" ") > -1){
                    columnType = columnType.substring(0, columnType.indexOf(" "));
                }
                if(columnType.contains("DATETIME")){
                    columnType="TIMESTAMP";
                }
                if(columnType.equals("INT")){
                    columnType="INTEGER";
                }
                fieldBean.setFieldType(columnType);

                //转换实体字段、类型、描述
                String proName = convertField(columnName);//转小驼峰
                String proType = convertTypeName(columnType);//转Java能识别的字段类型
                fieldBean.setProName(proName).setProType(proType).setProDes(columnDsc);
                columnList.add(fieldBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
    }

    /**
     * 获取表名备注
     * @param templateData
     * @param databaseName
     * @param tableName
     */
    private void getTableDesc(Map<String, Object> templateData, String databaseName, String tableName){
        //获取数据源连接
        Connection conn = super.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT TABLE_COMMENT FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '"+databaseName+"' AND table_name = '"+tableName+"'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            if (rs.next()) {
                templateData.put("tableDes", rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
    }

    /**
     * 如果有分隔符去掉分隔符号
     * @param field
     * @return
     */
    private String convertField(String field) {
        // 分隔符
        char separator = '_';
        // 转化为小写
//        String variable = field.toLowerCase();
        String variable = new String(field);
        if (variable.indexOf(separator) > -1) {
            char[] varArray = variable.toCharArray();
            for (int i = 0; i < varArray.length; i++) {
                if (varArray[i] == separator && i < varArray.length - 1) {
                    //分隔符下一个字符转大写
                    varArray[i + 1] = Character.toUpperCase(varArray[i + 1]);
                }
            }
            variable = new String(varArray).replaceAll("_", "");
        }
        return variable;
    }

    /**
     * 获取字段对应的类型
     * @param columnType
     * @return
     */
    private String convertTypeName(String columnType) {
        if("VARCHAR".equals(columnType) || "CHAR".equals(columnType)){
            return "String";
        }
        if("BIGINT".equals(columnType)){
            return "Long";
        }
        if("DECIMAL".equals(columnType)){
            return "BigDecimal";
        }
        if("INTEGER".equals(columnType) || "INT".equals(columnType) || "TINYINT".equals(columnType) || "SMALLINT".equals(columnType) || "MEDIUMINT".equals(columnType)){
            return "Integer";
        }
        if("DOUBLE".equals(columnType)){
            return "Double";
        }
        if("FLOAT".equals(columnType)){
            return "Float";
        }
        if("BOOLEAN".equals(columnType)){
            return "Boolean";
        }
        if("TIME".equals(columnType) || "DATE".equals(columnType) || "DATETIME".equals(columnType) || "TIMESTAMP".equals(columnType)){
            return "Date";
        }
        return "String";
    }
}
