package com.example.generator.dao;

import java.sql.*;
import java.util.Map;

/**
 * @author panzhi
 * @Description
 * @since 2020-11-09
 */
public abstract class BaseDao {

    private Connection conn = null;

    public String databaseName;

    public String ipName;

    public String portName;

    private String url;

    private String userName;

    /**
     * 定义连接数据库的密码
     */
    private String passWord;

    public BaseDao(Map<String, Object> dbData) {
        this.databaseName = dbData.get("databaseName").toString();
        this.ipName = dbData.get("ipName").toString();
        this.portName = dbData.get("portName").toString();
        this.userName = dbData.get("userName").toString();
        this.passWord = dbData.get("passWord").toString();
		this.url= "jdbc:mysql://" + ipName + ":" + portName + "/" + databaseName;
    }

    /**
     *  获取数据库链接
     * @return
     */
    public Connection getConnection() {
        try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭结果集
     * @param rs
     * @param pst
     */
    public void closeResult(ResultSet rs, PreparedStatement pst) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     */
    public void closeCon() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeAll(ResultSet rs, PreparedStatement pst, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
