package com.ancel.test.collection;

import java.util.EnumMap;

import com.ancel.test.Enum.SeasonEnum;

public class EnumMapTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EnumMap<SeasonEnum, String> enumMap = new EnumMap<SeasonEnum, String>(SeasonEnum.class);
		enumMap. put(SeasonEnum.SUMMER, "夏日炎炎");
		enumMap. put(SeasonEnum.SPRING, "春暖花开");
		
		System.out.println(enumMap);
		
	}
}
