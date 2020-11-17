package com.example.generator.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;

/**
 * @author panzhi
 * @Description
 * @since 2020-11-09
 */
public class FreeMakerUtil {


    /**
     * 根据Freemark模板，生成文件
     * @param templateName:模板名
     * @param root：数据原型
     * @throws Exception
     */
    public void generateFile(String templateName, Map<String, Object> root, String packageName, String fileName) throws Exception {
        FileOutputStream fos=null;
        Writer out =null;
        try {
            // 通过一个文件输出流，就可以写到相应的文件中，此处用的是绝对路径
            String entityName = (String) root.get("entityName");
            String fileFullName = String.format(fileName, entityName);
            packageName = String.format(packageName, entityName.toLowerCase());

            String fileStylePackageName = packageName.replaceAll("\\.", "/");
            File file = new File(root.get("outUrl").toString() + "/" + fileStylePackageName + "/" + fileFullName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();

            Template template = getTemplate(templateName);
            fos = new FileOutputStream(file);
            out = new OutputStreamWriter(fos);
            template.process(root, out);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null){
                    fos.close();
                }
                if(out != null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * 获取模板文件
     *
     * @param name
     * @return
     */
    public Template getTemplate(String name) {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            cfg.setClassForTemplateLoading(this.getClass(), "/ftl");
            Template template = cfg.getTemplate(name);
            return template;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
