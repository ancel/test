package com.ancel.test.algorithm.sort;

/**
 * 冒泡排序
 * @author：ancel.wang
 * @creattime：2018年9月7日 下午4:39:39 
 * 
 */  
public class Bubble {
	public static void main(String[] args) {
		int[] a = {4, 2, 5, 6, 1, 12, 3, 0};
		for (int i : sort(a)) {
			System.out.println(i);
		}
	}
	
	public static int[] sort(int[] a){
		for (int i = 0; i < a.length-1; i++) {
			boolean swapped = false;
			for (int j = 0; j < a.length-1-i; j++) {
				if(a[j]<a[j+1]){
					int tempVal = a[j];
					a[j] = a[j+1];
					a[j+1] = tempVal;
					swapped = true;
				}
			}
			if(!swapped){
				break;
			}
			for (int m : a) {
				System.out.print(m+",");
			}
			System.out.println();
		}
		return a;
	}
}
