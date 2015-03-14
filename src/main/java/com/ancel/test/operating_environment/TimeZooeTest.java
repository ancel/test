package com.ancel.test.operating_environment;

import java.util.Arrays;
import java.util.TimeZone;

/*
 * 时区
 */
public class TimeZooeTest {
	public static void main(String[] args) {
		//获取java支持的所有时区的id
		String[] ids = TimeZone.getAvailableIDs();
		System.out.println(Arrays.toString(ids));
		
		//获取自己所在时区
		TimeZone myZone = TimeZone.getDefault();
		System.out.println(myZone.getID());
		System.out.println(myZone.getDisplayName());
		
		//获取指定id时间
		System.out.println(TimeZone.getTimeZone("CNT").getDisplayName());
		System.out.println(TimeZone.getTimeZone("cnt").getDisplayName());
		System.out.println(TimeZone.getTimeZone("Asia/Shanghai").getDisplayName());
	}
}
