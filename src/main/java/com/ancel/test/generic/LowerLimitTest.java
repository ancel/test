package com.ancel.test.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * 设定泛型类型的下限
 */
public class LowerLimitTest {
	public static <T> T copy(Collection<? super T> dest,Collection<T> src){
		T last = null;
		for(T t:src){
			last = t;
			dest.add(t);
		}
		return last;
	}
	public static void main(String[] args) {
		List<Number> ln = new ArrayList<Number>();
		List<Integer> li = new ArrayList<Integer>();
		li.add(5);
		li.add(4);
		li.add(3);
		Integer last = copy(ln, li);
		System.out.println(last);
		
	}
}
