package com.ancel.test.utils;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
 
public class PropertiesUtils {
 
 
    public static final String PROPERTIES_LOCATION = "/config/app_constant.properties";
 
    private static Properties properties = new Properties();
 
    /**
     * 初始化properties，即载入数据
     */
    private static void initProperties() {
        try {
            InputStream ips = PropertiesUtils.class.getResourceAsStream(PROPERTIES_LOCATION);
            properties.load(ips);
            ips.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
 
 
    public static String getProp(String key) {
        initProperties();
        return properties.getProperty(key);
    }
 
    public static void setProp(String key, String value) {
        if (properties.isEmpty()){// 如果properties为空，则初始化一次。
            initProperties();
        }
 
        properties.setProperty(key, value);
        //保存文件
        try {
            URL fileUrl = PropertiesUtils.class.getResource(PROPERTIES_LOCATION);//得到文件路径
            FileOutputStream fos = new FileOutputStream(new File(fileUrl.toURI()));
            properties.store(fos, "the primary key of article table");
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
    public static void main(String[] args) {
        //GiftPropUtils.setProp("SB_JINTJI_NUM", "16");
        System.out.println(PropertiesUtils.getProp("JINGJI_START_NUM"));
    }
}