package com.ancel.test.operating_environment;

public class StringBuilderTest {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		//追加字符串
		sb.append("java");
		System.out.println(sb);
		//插入字符串
		sb.insert(2, "hello");
		System.out.println(sb);
		//删除字符串
		sb.delete(3, 5);
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		sb.setLength(5);
		System.out.println(sb);
	}
}
