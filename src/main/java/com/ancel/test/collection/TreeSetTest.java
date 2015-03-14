package com.ancel.test.collection;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		SortedSet nums = new TreeSet();
		nums.add(12);
		nums.add(2);
		nums.add(-12);
		nums.add(-9);
		nums.add(-30);
		System.out.println(nums);
		System.out.println(nums.first());
		System.out.println(nums.last());
		System.out.println(nums.headSet(0));
		System.out.println(nums.tailSet(0));
		System.out.println(nums.subSet(-20, 10));
		
	}

}
