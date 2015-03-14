package com.ancel.test.collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("username", "admin");
		props.setProperty("password", "3223");
		try {
			props.store(new FileOutputStream("D:/io.ini"), "comment line");
			Properties props2 = new Properties();
			props2.setProperty("gender", "male");
			props2.load(new FileInputStream("D:/io.ini"));
			System.out.println(props2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
