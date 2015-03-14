package com.ancel.test.annotation;

import java.lang.reflect.Method;

public class TagTest {
	
	@MyTag
	public void info(){
		System.out.println("info");
	}
	public static void main(String[] args) {
		TagTest tt = new TagTest();
		try {
			Method method = tt.getClass().getMethod("info");
			method.invoke(tt);
			MyTag myTag = method.getAnnotation(MyTag.class);
			System.out.println(myTag.name());
			System.out.println(myTag.age());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
