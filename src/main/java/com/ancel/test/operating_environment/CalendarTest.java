package com.ancel.test.operating_environment;


import java.util.Calendar;
import java.util.Date;
/*
 * 1、add修改日期时会修改上级字段（比如修改月超出范围时，会修改年），roll不会，对于下级字段的修改是一样的。
 * 2、setLenient(boolean),false为关闭容错性，即set日期时是否正确
 */
public class CalendarTest {
	public static void main(String[] args) {
		Calendar calendar= Calendar.getInstance();
		Date date = calendar.getTime();
		System.out.println(date);
		
		calendar.setTime(date);
		System.out.println(calendar.get(Calendar.YEAR));
		//以0开始
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DATE));
		
		calendar.set(2003, 10, 10, 12, 10);
		System.out.println(calendar.getTime());
		
		calendar.add(Calendar.YEAR, -1);
		System.out.println(calendar.getTime());
		calendar.add(Calendar.MONTH, 6);
		System.out.println(calendar.getTime());
		
		
	}
}
