package com.ancel.test.operating_environment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindGroupTest {
	public static void main(String[] args) {
		//\w匹配所有单词字符
		Matcher m = Pattern.compile("\\w+").matcher("java is very easy 4");
		while(m.find()){
			System.out.println(m.group());
		}
		
		int i = 0;
		//传入i表示在从该索引向下查找
		while(m.find(i)){
			System.out.print(m.group()+"\t");
			i++;
		}
	}
}
