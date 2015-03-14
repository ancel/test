package com.ancel.test.classloader;

public class ClassLoaderTest {
	public static void main(String[] args) {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		
		try {
			//下面语句仅仅是加载Tester类
			cl.loadClass("Tester");
			System.out.println("系统初始化Tester类");
			//下面语句会初始化Tester
			Class.forName("Tester");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Tester{
	static{
		System.out.println(ClassLoaderTest.class.getSimpleName()+"静态初始化开始");
	}
}
