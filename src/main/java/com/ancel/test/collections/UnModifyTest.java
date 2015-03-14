package com.ancel.test.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnModifyTest {
	public static void main(String[] args) {
		//创建一个空的、不可变的list对象
		List<String> unModifyList = Collections.emptyList();
		//创建一个只有一个元素且不可变的set
		Set<String> unModifySet = Collections.singleton("spring");
		Map<String,Integer> scores = new HashMap<String, Integer>();
		scores.put("语文", 98);
		scores.put("数学", 97);
		scores.put("英语", 92);
		
		Map<String, Integer> unModifyMap = Collections.unmodifiableMap(scores);
		
		//三个都将引发异常
		unModifyList.add("nihao");
		unModifySet.add("hibernate");
		unModifyMap.put("物理", 91);
		
	}
}
