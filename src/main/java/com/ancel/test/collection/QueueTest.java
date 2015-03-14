package com.ancel.test.collection;

import java.util.LinkedList;

public class QueueTest {
	
	public static void main(String[] args) {
		LinkedList<String> books = new LinkedList<String>();	
		books.offer("struts");
		books.push("spring");
		books.offerFirst("hibernate");
		//排序结果为[hibernate, spring, struts]
		System.out.println(books);
		System.out.println(books.peek());
		
		System.out.println(books.peekFirst());
		System.out.println(books.peekLast());
		
		System.out.println(books.pop());
		System.out.println(books);
		
		System.out.println(books.pollLast());
		System.out.println(books);
	}
}
