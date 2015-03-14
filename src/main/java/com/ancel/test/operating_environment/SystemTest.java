package com.ancel.test.operating_environment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class SystemTest {
	public static void main(String[] args) {
		Map<String, String> env = System.getenv();
		for(String name:env.keySet()){
			System.out.println(name+"-------->"+env.get(name));
		}
		//获取指定环境变量
		System.out.println(System.getenv("JAVA_HOME"));
		//获取所有系统属性
		Properties props = System.getProperties();
		try {
			props.store(new FileOutputStream("D:/props.txt"), "system properties");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取系统名称
		System.out.println(System.getProperty("os.name"));
		//返回与utc1970.1.1的时间差，单位为毫秒
		System.out.println(System.currentTimeMillis());
		//返回与utc1970.1.1的时间差，单位为微秒
		System.out.println(System.nanoTime());
	}
}
