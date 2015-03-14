package com.ancel.test.collection;

import java.util.HashSet;
import java.util.Set;

public class SetListTest {
	public static void main(String[] args) {
		Set<String> ss = new HashSet<String>();
		ss.add("java");
		ss.add("spring");
		ss.add("hibernate");
		ss.add("struts");
		
		//只有一个元素时不会报错，大于一个时就报错
		for(String s:ss){
			ss.remove(s);
			System.out.println(s);
		}
	}
}
