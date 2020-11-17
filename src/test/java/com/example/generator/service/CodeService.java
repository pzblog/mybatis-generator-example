package com.example.generator.service;

import com.example.generator.util.FreeMakerUtil;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author panzhi
 * @Description
 * @since 2020-11-09
 */
public class CodeService {

    public void generate(Map<String, Object> templateData) {
        //包前缀
        String packagePreAndModuleName = getPackagePreAndModuleName(templateData);

        //支持对应实体插入在前面，需要带上%s
        templateData.put("entityPackageName", String.format(packagePreAndModuleName + ".entity",
                templateData.get("entityName").toString().toLowerCase()));

        templateData.put("dtoPackageName", String.format(packagePreAndModuleName + ".dto",
                templateData.get("entityName").toString().toLowerCase()));

        templateData.put("voPackageName", String.format(packagePreAndModuleName + ".vo",
                templateData.get("entityName").toString().toLowerCase()));

        templateData.put("daoPackageName", String.format(packagePreAndModuleName + ".dao",
                templateData.get("entityName").toString().toLowerCase()));

        templateData.put("mapperPackageName", packagePreAndModuleName + ".mapper");


        templateData.put("servicePackageName", String.format(packagePreAndModuleName + ".service",
                templateData.get("entityName").toString().toLowerCase()));

        templateData.put("serviceImplPackageName", String.format(packagePreAndModuleName + ".service.impl",
                templateData.get("entityName").toString().toLowerCase()));

        templateData.put("controllerPackageName", String.format(packagePreAndModuleName + ".web",
                templateData.get("entityName").toString().toLowerCase()));

        templateData.put("apiTestPackageName", String.format(packagePreAndModuleName + ".junit",
                templateData.get("entityName").toString().toLowerCase()));


        templateData.put("currentTime", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        //======================生成文件配置======================
        try {
            // 生成Entity
            String entityName = String.format("%s", templateData.get("entityName").toString());
            generateFile("entity.ftl", templateData, templateData.get("entityPackageName").toString(), entityName+".java");

            // 生成dto
            String dtoName = String.format("%sDTO", templateData.get("entityName").toString());
            templateData.put("dtoName", dtoName);
            generateFile("dto.ftl", templateData, templateData.get("dtoPackageName").toString(),
                    dtoName + ".java");

            // 生成VO
            String voName = String.format("%sVO", templateData.get("entityName").toString());
            templateData.put("voName", voName);
            generateFile("vo.ftl", templateData, templateData.get("voPackageName").toString(),
                    voName + ".java");

            // 生成DAO
            String daoName = String.format("%sDao", templateData.get("entityName").toString());
            templateData.put("daoName", daoName);
            generateFile("dao.ftl", templateData, templateData.get("daoPackageName").toString(),
                    daoName + ".java");

            // 生成Mapper
            String mapperName = String.format("%sMapper", templateData.get("entityName").toString());
            generateFile("mapper.ftl", templateData, templateData.get("mapperPackageName").toString(),
                    mapperName+".xml");


            // 生成Service
            String serviceName = String.format("%sService", templateData.get("entityName").toString());
            templateData.put("serviceName", serviceName);
            generateFile("service.ftl", templateData, templateData.get("servicePackageName").toString(),
                    serviceName + ".java");

            // 生成ServiceImpl
			String serviceImplName = String.format("%sServiceImpl", templateData.get("entityName").toString());
			templateData.put("serviceImplName", serviceImplName);
			generateFile("serviceImpl.ftl", templateData, templateData.get("serviceImplPackageName").toString(),
                    serviceImplName + ".java");

            // 生成Controller
			String controllerName = String.format("%sController", templateData.get("entityName").toString());
			templateData.put("controllerName", controllerName);
			generateFile("controller.ftl", templateData, templateData.get("controllerPackageName").toString(),
                    controllerName + ".java");

//			// 生成junit测试类
//            String apiTestName = String.format("%sApiTest", templateData.get("entityName").toString());
//            templateData.put("apiTestName", apiTestName);
//            generateFile("test.ftl", templateData, templateData.get("apiTestPackageName").toString(),
//                    apiTestName + ".java");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成文件
     * @param templateName 模板名称
     * @param templateData 参数名
     * @param packageName 包名
     * @param fileName 文件名
     */
    public void generateFile(String templateName, Map<String, Object> templateData, String packageName, String fileName) {
        templateData.put("fileName", fileName);

        DaseService dbService = new DaseService(templateData);

        // 获取数据库参数
        if("entity.ftl".equals(templateName) || "mapper.ftl".equals(templateName)){
            dbService.getAllColumns(templateData);
        }
        try {
            // 默认生成文件的路径
            FreeMakerUtil freeMakerUtil = new FreeMakerUtil();
            freeMakerUtil.generateFile(templateName, templateData, packageName, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 封装包名前缀
     * @return
     */
    private String getPackagePreAndModuleName(Map<String, Object> templateData){
        String packageNamePre = templateData.get("packageNamePre").toString();
        String moduleName = templateData.get("moduleName").toString();
        if(StringUtils.isNotBlank(moduleName)){
            return packageNamePre + "." + moduleName;
        }
        return packageNamePre;
    }


}
