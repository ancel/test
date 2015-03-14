package com.ancel.test.operating_environment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailMatcherTest {
	public static void main(String[] args) {
		String[] mails = { "adsf@163.com", "gagfadgka@sohu.gov",
				"oigoerjg@qq.net", "asdag@sina.xx" ,"a@126.cn","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@126.cn"};
		String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
		Pattern mailPattern = Pattern.compile(mailRegEx);
		Matcher m = null;
		for(String mail:mails){
			if(m==null){
				m = mailPattern.matcher(mail);
			}else{
				m.reset(mail);
			}
			if(m.matches()){
				System.out.println(mail+"是一个有效的邮件地址");
			}else{
				System.out.println(mail+"不是一个有效的邮件地址");
			}
			
			//字符串提供的匹配
			if(mail.matches(mailRegEx)){
				System.out.println(mail+"是一个有效的邮件地址");
			}else{
				System.out.println(mail+"不是一个有效的邮件地址");
			}
		}
	}
}
