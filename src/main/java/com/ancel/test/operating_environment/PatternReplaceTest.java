package com.ancel.test.operating_environment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternReplaceTest {
	public static void main(String[] args) {
		String[] mails = { "adsf@163 regular .com", "gagf regular adgka@sohu.gov",
				"oigoerjg@qq.net", "as reasdfasdf dag@sina.xx" ,"a@126.cn","aaaaaaa@126.cn"};
		Pattern p = Pattern.compile("re\\w*");
		Matcher matcher = null;
		for(String mail:mails){
			if(matcher==null){
				matcher = p.matcher(mail);
			}else{
				matcher.reset(mail);
			}
			System.out.println(matcher.replaceAll("哈哈\2"));
		}
	}
}
