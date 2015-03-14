package com.ancel.test.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest {
	public static void main(String[] args) {
		//获取系统类加载器
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器："+systemLoader);
		/*
		 * 获取系统加载器的加载路径——通常由classpath环境变量指定
		 * 如果操作系统没有指定classpath环境变量，默认以当前路径
		 * 作为系统类加载器的加载路径
		 */
		Enumeration<URL> eml;
		try {
			eml = systemLoader.getResources("");
			while(eml.hasMoreElements()){
				System.out.println(eml.nextElement());
			}
			//获取系统类加载器的父类加载器——应该得到扩展类加载器
			ClassLoader extensionLoader = systemLoader.getParent();
			System.out.println("扩展类加载器："+extensionLoader);
			System.out.println("扩展类加载器的加载路径："+System.getProperty("java.ext.dirs"));
			System.out.println("扩展类加载器的parent："+extensionLoader.getParent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
