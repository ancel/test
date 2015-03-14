package com.ancel.test.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		HashSet books = new LinkedHashSet();
		books.add("spring");
		books.add("hibernate");
		books.remove("spring");
		books.add("spring");
		System.out.println(books);
	}
}
