package com.ancel.test.collection;

import java.util.HashMap;
/*
 * HashMap可以添加空键值对，但是不能重复
 */
public class NullInHashMap {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put(null, null);
		hm.put(null, null);
		//会将前面放入的覆盖
		hm.put(null, "s");
		hm.put("a", null);
		System.out.println(hm);
	}
}
