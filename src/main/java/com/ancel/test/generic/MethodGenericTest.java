package com.ancel.test.generic;

import java.util.ArrayList;
import java.util.Collection;

public class MethodGenericTest {
	public static <T> void fromArrayToCollection(T[] a,Collection<T> c){
		for(T t:a){
			c.add(t);
		}
	}
	
	public static void main(String[] args) {
		Object[] ob = new Object[100];
		Collection<Object> c = new ArrayList<Object>();
		fromArrayToCollection(ob, c);
		
		String[] ob1 = new String[100];
		Collection<String> c1 = new ArrayList<String>();
		fromArrayToCollection(ob1, c1);
	}
}
