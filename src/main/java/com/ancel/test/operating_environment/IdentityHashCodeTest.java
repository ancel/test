package com.ancel.test.operating_environment;
/*
 * 获取对象根据其地址计算的hashcode
 */
public class IdentityHashCodeTest {
	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
		//string已经重写了hashcode方法
		System.out.println(s1.hashCode()+"-----"+s2.hashCode());
		System.out.println(System.identityHashCode(s1)+"-----"+System.identityHashCode(s2));
		
		String s3 = "java";
		String s4 = "java";
		System.out.println(System.identityHashCode(s3)+"-----"+System.identityHashCode(s4));
	}
}
