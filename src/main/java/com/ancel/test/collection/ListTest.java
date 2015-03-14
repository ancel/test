package com.ancel.test.collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List books = new ArrayList();
		books.add("struts");
		books.add("spring");
		books.add("hibernate");
		System.out.println(books);
		
		books.add(1, "freemaker");
		
		for(Object o:books){
			System.out.println(o.toString());
		}
		
		books.remove(3);
		System.out.println(books);
		
		System.out.println(books.indexOf("freemaker"));
		
		books.set(1, "dubbo");
		System.out.println(books);
		
		System.out.println(books.subList(1, 3));
	}
}
