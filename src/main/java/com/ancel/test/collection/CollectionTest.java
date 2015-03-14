package com.ancel.test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("悟空");
		c.add(6);
		System.out.println(c.size());
		c.remove(6);
		System.out.println(c.size());
		System.out.println("是否包含悟空："+c.contains("悟空"));
		c.add("spring");
		System.out.println("c集合的元素："+c);
		
		
		Collection books = new HashSet();
		books.add("hibernate");
		books.add("spring");
		System.out.println("c集合是否完全包含books："+c.containsAll(books));
		//去重
		c.removeAll(books);
		System.out.println("c集合的元素："+c);
		
		c.clear();
		System.out.println("c集合的元素："+c);
		//books集合只剩下c集合也同时包含的元素
		books.retainAll(c);
		System.out.println("books集合的元素："+books);
		
	}
}
