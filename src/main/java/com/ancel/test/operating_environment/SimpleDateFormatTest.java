package com.ancel.test.operating_environment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
	public static void main(String[] args) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("Gyyyy年的第D天");
		String dateStr = sdf.format(d);
		System.out.println(dateStr);
		String str = "07###三月##21";
		SimpleDateFormat sdf2 = new SimpleDateFormat("y###MMM##d");
		try {
			System.out.println(sdf2.parse(str));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("y-M-d H:m:s");
		String str1 = sdf3.format(d);
		System.out.println(str1);
	}
}
