package com.ancel.test.collection;

import java.util.WeakHashMap;

public class WeakHashMapTest {
	public static void main(String[] args) {
		WeakHashMap<String, String> whm = new WeakHashMap<String, String>();
		//key皆为弱引用
		whm.put(new String("语文"), new String("良"));
		whm.put(new String("数学"), new String("优"));
		whm.put(new String("英语"), new String("差"));
		
		//改key是一个系统缓存的字符串对象，下面两个在gc之后不会消失
		whm.put("java", new String("优"));
		String s = new String("php");
		whm.put(s, new String("优"));
		System.out.println(whm);
		System.gc();
		System.runFinalization();
		System.out.println(whm);
	}
}
