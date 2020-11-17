package com.example.generator.constant;

import java.io.IOException;
import java.util.Properties;

/**
 * @author panzhi
 * @Description
 * @since 2020-11-09
 */
public class SystemConstant {

    private static Properties properties = new Properties();

    static {
        try {
            // 加载上传文件设置参数：配置文件
            properties.load(SystemConstant.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String tableName = properties.getProperty("tableName");
    public static final String entityName = properties.getProperty("entityName");
    public static final String packageNamePre = properties.getProperty("packageNamePre");
    public static final String outUrl = properties.getProperty("outUrl");
    public static final String databaseName = properties.getProperty("databaseName");
    public static final String ipName = properties.getProperty("ipName");
    public static final String portName = properties.getProperty("portName");
    public static final String userName = properties.getProperty("userName");
    public static final String passWord = properties.getProperty("passWord");
    public static final String authorName = properties.getProperty("authorName");

    public static final String primaryId = properties.getProperty("primaryId");

    public static final String moduleName = properties.getProperty("moduleName");
}
