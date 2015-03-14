package com.ancel.test.i18n;

import java.util.Locale;

public class LocaleTest {
	public static void main(String[] args) {
		Locale[] localeList = Locale.getAvailableLocales();
		for(Locale locale:localeList){
			System.out.println(locale.getDisplayCountry()+"="+locale.getCountry()+";"+locale.getDisplayLanguage()+"="+locale.getLanguage());;
		}
	}
}
