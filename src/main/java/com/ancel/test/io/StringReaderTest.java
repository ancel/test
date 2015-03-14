package com.ancel.test.io;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderTest {
	public static void main(String[] args) {
		String src = "从明天起，\n"+"做一个幸福的人\n";
		StringReader sr = new StringReader(src);
		char[] buffer = new char[32];
		int hasRead = 0;
		try {
			while((hasRead = sr.read(buffer))>0){
				System.out.println(new String(buffer,0,hasRead));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sr.close();
		}
		
		StringWriter sw = new StringWriter(32);
		sw.write("面朝大海春暖花开\n");
		sw.write("我是海子，我死了");
		System.out.println(sw.toString());
 	}
}
