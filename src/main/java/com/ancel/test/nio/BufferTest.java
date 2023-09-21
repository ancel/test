package com.ancel.test.nio;

import java.nio.CharBuffer;

public class BufferTest {
	public static void main(String[] args) {
		CharBuffer cb = CharBuffer.allocate(8);
		System.out.println("capacity  "+cb.capacity());
		System.out.println("limit  "+cb.limit());
		System.out.println("position  "+cb.position());
		
		cb.put('a');
		cb.put('b');
		cb.put('c');
		System.out.println("加入三个元素之后，position="+cb.position());
		System.out.println("加入三个元素之后，limit="+cb.limit());
		
		cb.flip();
		System.out.println("执行flip方法之后，limit="+cb.limit());
		System.out.println("position="+cb.position());
		cb.put('d');
		cb.put('e');
		
		System.out.println("取出第一个元素"+cb.get());

		
		cb.clear();
		System.out.println("执行clear方法后，limit  "+cb.limit());
		System.out.println("执行clear方法后，position  "+cb.position());
		System.out.println("执行clear方法后，缓冲器没有被清楚"+cb.get(2));
		System.out.println("执行绝对读取后，position "+cb.position());
	}
}
