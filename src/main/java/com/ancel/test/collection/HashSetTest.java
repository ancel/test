package com.ancel.test.collection;

import java.util.HashSet;

class A{

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}
	
}

class B{

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}
	
}

class C{

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}
	
}

public class HashSetTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		HashSet books = new HashSet();
		books.add(new A());
		books.add(new A());
		books.add(new B());
		books.add(new B());
		books.add(new C());
		books.add(new C());
		System.out.println(books);
		System.out.println(books.size());
	}
}
