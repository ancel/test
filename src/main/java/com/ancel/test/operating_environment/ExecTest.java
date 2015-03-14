package com.ancel.test.operating_environment;

import java.io.IOException;

public class ExecTest {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("notepad");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
