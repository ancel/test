package com.ancel.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	
	@Test
	public void testList(){
		String s = "123";
		List<String> strList = new ArrayList<>();
		strList.add(s);
		s = "234";
		strList.add(s);
		strList.add(null);
		
		for (String string : strList) {
			System.out.println(string);
		}
	}
}
