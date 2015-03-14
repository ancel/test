package com.ancel.test.classloader;

public class StaticTest {
	static int a = 3;
	static{
		a = 4;
		b=3;
	}
	static int b = 5;
	public static void main(String[] args) {
		//将会打印4
		System.out.println(a);
		//将会打印5
		System.out.println(b);
		
		
	}
}
