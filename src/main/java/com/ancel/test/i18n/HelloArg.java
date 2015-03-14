package com.ancel.test.i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloArg {
	public static void main(String[] args) {
		//Locale currentLocale = new Locale(language, country);
		Locale currentLocale = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("locale2", currentLocale);
		String msg = bundle.getString("msg");
		System.out.println(MessageFormat.format(msg, "王海波",new Date()));
		
		ResourceBundle bundle2 = ResourceBundle.getBundle("Class", currentLocale);
		String msg2 = bundle2.getString("msg");
		System.out.println(MessageFormat.format(msg2, "王海波",new Date()));
	}
}
