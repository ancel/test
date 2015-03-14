package com.ancel.test.collection;

import java.util.LinkedHashMap;
/*
 * LinkedHashMap可以维护元素插入顺序
 */
public class LinkedHashMapTest {
	public static void main(String[] args) {
		 LinkedHashMap<String, Integer> scores = new LinkedHashMap<String, Integer>();
		 scores.put("语文", 98);
		 scores.put("数学", 94);
		 scores.put("英语", 92);
		 for(String key : scores.keySet()){
			 System.out.println(key+"="+scores.get(key));
		 }
	}
}
