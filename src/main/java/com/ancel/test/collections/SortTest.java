package com.ancel.test.collections;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest {
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(17);
		nums.add(7);
		nums.add(-7);
		nums.add(12);
		nums.add(1);
		System.out.println(nums);
		//将list数据反转
		Collections.reverse(nums);
		System.out.println(nums);
		//排序
		Collections.sort(nums);
		System.out.println(nums);
		//随机排序
		Collections.shuffle(nums);
		System.out.println(nums);
		
		Collections.shuffle(nums);
		System.out.println(nums);
	}
}
