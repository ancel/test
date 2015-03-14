package com.ancel.test.collection;

import java.util.Stack;

public class VectorTest {
	public static void main(String[] args) {
		Stack<String> v = new Stack<String>();
		v.push("struts");
		v.push("spring");
		v.push("hibernate");
		System.out.println(v);
		//访问栈顶元素，但不将元素出栈
		System.out.println(v.peek());
		System.out.println(v);
		
		//取出栈顶元素
		System.out.println(v.pop());
		System.out.println(v);
	}
}
