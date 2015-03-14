package com.ancel.test.collection;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;

import com.ancel.test.Enum.SeasonEnum;

public class EnumSetTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		EnumSet<SeasonEnum> es1 = EnumSet.allOf(SeasonEnum.class);
		System.out.println(es1);
		
		EnumSet<SeasonEnum> es2 = EnumSet.noneOf(SeasonEnum.class);
		System.out.println(es2);
		
		es2.add(SeasonEnum.SPRING);
		es2.add(SeasonEnum.FALL);
		System.out.println(es2);
		
		EnumSet<SeasonEnum> es3 = EnumSet.of(SeasonEnum.SUMMER, SeasonEnum.WINTER);
		System.out.println(es3);
		
		//取一段enum
		EnumSet<SeasonEnum> es4 = EnumSet.range(SeasonEnum.SUMMER, SeasonEnum.WINTER);
		System.out.println(es4);
		
		//es5+es4=SeasonEnum的全部元素
		EnumSet<SeasonEnum> es5 = EnumSet.complementOf(es4);
		System.out.println(es5);
		
		Collection c = new HashSet();
		c.clear();
		c.add(SeasonEnum.SPRING);
		c.add(SeasonEnum.WINTER);
		//c中的元素必须都为枚举
		EnumSet es6 = EnumSet.copyOf(c);
		System.out.println(es6);
	}
}
