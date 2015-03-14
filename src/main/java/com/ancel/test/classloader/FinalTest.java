package com.ancel.test.classloader;

public class FinalTest {
	public static final String FLAG = "helloworld";
	public static final String currentTime = System.currentTimeMillis()+""; 
	public static void main(String[] args) {
		//flag被当做字符常量，程序中所有使用flag的地方都会在编译器被替换成该常量的值，
		//所以下面的语句不会初始化FinalTest
		System.out.println(FinalTest.FLAG);
		
		//因为currentTime的值必须在运行期才可以确定,所以下面的代码必须保留对FianlTest的静态属性的引用
		//下面的代码就变成了使用currentTime的静态属性，这将导致FianlTest被初始化。
		System.out.println(FinalTest.currentTime);
	}
}
