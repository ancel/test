package com.ancel.test.collections;

import java.util.ArrayList;
import java.util.Collections;

public class SearchTest {
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(17);
		nums.add(7);
		nums.add(1);
		nums.add(-7);
		nums.add(12);
		nums.add(1);
		System.out.println(nums);
		
		System.out.println("max="+Collections.max(nums));
		System.out.println("min="+Collections.min(nums));
		
		Collections.replaceAll(nums, 1, 0);
		System.out.println(nums);
		
		System.out.println("0在nums中出现的次数"+Collections.frequency(nums, 0));
		
		Collections.sort(nums);
		System.out.println(nums);
		
		//只有排序之后的list集合才可用二分查找法
		System.out.println(Collections.binarySearch(nums, 0));
		
		
	}
}
