package com.ancel.test.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {
	public static void main(String[] args) {
		//将application/x-www-form-urlencoded字符串转换成普通字符串
		try {
			String keyWord = URLDecoder.decode("%E6%9D%8E%E5%88%9A", "utf-8");
			System.out.println(keyWord);
			String urlStr = URLEncoder.encode("李刚j2ee", "utf-8");
			System.out.println(urlStr);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
