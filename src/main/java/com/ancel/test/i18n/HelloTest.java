package com.ancel.test.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloTest {
	public static void main(String[] args) {
		Locale myLocale = Locale.getDefault();
		ResourceBundle rb = ResourceBundle.getBundle("locale", myLocale);
		System.out.println(rb.getString("hello"));
	}
}
