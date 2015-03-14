package com.ancel.test.operating_environment;

public class StringTest {
	public static void main(String[] args) {
		char[] chs = {'a','b','c','d','E','f','g','h','i'};
		String s = String.copyValueOf(chs);
		System.out.println(s);
		//取指定位置字符
		System.out.println(s.charAt(4));
		//全部变为大写
		System.out.println(s.toUpperCase());
		//全部变为小写
		System.out.println(s.toLowerCase());
		char[] chs1 = s.toCharArray();
		System.out.println(chs1);
		
		//比较字符串
		String s1 = new String("abcdefghiklmn");
		String s2 = new String("abcdefghi");
		String s3 = new String("abcdefghialmn");
		System.out.println("s1.compareTo(s2):"+s1.compareTo(s2));//返回长度差：4
		System.out.println("s1.compareTo(s3):"+s1.compareTo(s3));//返回'k'-'a'的差
		
		//忽略大小写比较
		System.out.println(s.equalsIgnoreCase(s2));
		
		//返回从位置2开始字符f第一次出现的位置（字符串也可以）
		int index= s.indexOf('f', 2);
		System.out.println(index);
	}
}
