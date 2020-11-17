package com.example.generator.entity;

/**
 * @author panzhi
 * @Description
 * @since 2020-11-09
 */
public class FieldBean {

    /**
     * 数据库原字段名
     */
    private String fieldName;

    /**
     * 数据库原字段类型
     */
    private String fieldType;

    /**
     * 转换成实体类的-变量名
     */
    private String proName;

    /**
     * 转换成实体类的-变量类型
     */
    private String proType;

    /**
     * 转换成实体类的变量-变量注释
     */
    private String proDes;


    public String getFieldName() {
        return fieldName;
    }

    public FieldBean setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public String getFieldType() {
        return fieldType;
    }

    public FieldBean setFieldType(String fieldType) {
        this.fieldType = fieldType;
        return this;
    }

    public String getProName() {
        return proName;
    }

    public FieldBean setProName(String proName) {
        this.proName = proName;
        return this;
    }

    public String getProType() {
        return proType;
    }

    public FieldBean setProType(String proType) {
        this.proType = proType;
        return this;
    }

    public String getProDes() {
        return proDes;
    }

    public FieldBean setProDes(String proDes) {
        this.proDes = proDes;
        return this;
    }
}
