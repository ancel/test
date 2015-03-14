package com.ancel.test.operating_environment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternStartEndTest {
	public static void main(String[] args) {
		String str = "java is very easy !";
		Matcher m  = Pattern.compile("\\w+").matcher(str);
		while(m.find()){
			System.out.println(m.group()+"字串起始位置："+m.start()+",结束为止:"+m.end());
		}
	}
}
