package com.example.generator;

import com.example.generator.constant.SystemConstant;
import com.example.generator.service.CodeService;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author panzhi
 * @Description
 * @since 2020-11-09
 */
public class GeneratorMain {

    public static void main(String[] args) {
        System.out.println("生成代码start......");

        //获取页面或者配置文件的参数
        Map<String, Object> templateData = new HashMap<String, Object>();
        templateData.put("tableName", SystemConstant.tableName);
        System.out.println("表名=="+ SystemConstant.tableName);

        templateData.put("entityName", SystemConstant.entityName);
        System.out.println("实体类名称=="+ SystemConstant.entityName);

        templateData.put("packageNamePre", SystemConstant.packageNamePre);
        System.out.println("包名前缀=="+ SystemConstant.packageNamePre);

        //支持自定义输出路径
        if(StringUtils.isNotBlank(SystemConstant.outUrl)){
            templateData.put("outUrl", SystemConstant.outUrl);
        } else {
            String path = GeneratorMain.class.getClassLoader().getResource("").getPath() + "../../src/main/java";
            templateData.put("outUrl", path);
        }
        System.out.println("生成文件路径为=="+ templateData.get("outUrl"));

        templateData.put("authorName", SystemConstant.authorName);
        System.out.println("以后代码出问题找=="+ SystemConstant.authorName);


        templateData.put("databaseName", SystemConstant.databaseName);
        templateData.put("ipName", SystemConstant.ipName);
        templateData.put("portName", SystemConstant.portName);
        templateData.put("userName", SystemConstant.userName);
        templateData.put("passWord", SystemConstant.passWord);

        //主键ID
        templateData.put("primaryId", SystemConstant.primaryId);

        //模块名称
        templateData.put("moduleName", SystemConstant.moduleName);
        CodeService dataService = new CodeService();

        try {
            //生成代码文件
            dataService.generate(templateData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("生成代码end......");
    }
}
