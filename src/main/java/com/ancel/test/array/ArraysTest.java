package com.ancel.test.array;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[] args) {
		int[] a = {3,4,5,6};
		int[] a1 = {3,4,5,6};
		System.out.println("数组a和a1是否相等"+Arrays.equals(a1, a));
		
		int[] b = Arrays.copyOf(a, 6);
		System.out.println(Arrays.toString(b));
		//将数组b第三个元素（包括）到第五个元素（不包括）替换为1
		Arrays.fill(b, 3, 5, 1);
		System.out.println(Arrays.toString(b));
		//排序从小到大
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
	}
}
