package com.ancel.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class JunitTest {

	@Test
	public void testExpress() {
		int a = 3;
		a -=a*a;
		a += a;
		System.out.println(a);
		
		int b = 3;
		b+=b-=b*b;
		System.out.println(b);
		a = a+(a-a*a);
		a = 3+ (3 - 3*3);
	}
	
	
	@Test
	public void testBoolean(){
		Boolean a = new Boolean(true);
		String b = new String("why me?");
		int c = Integer.parseInt(1+"");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	
	@Test
	public void testHashMap(){
		System.out.println(1<<10);
		Map<String, String> map = new HashMap<>();
	}
	
}
