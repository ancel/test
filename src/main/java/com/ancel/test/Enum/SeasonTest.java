package com.ancel.test.Enum;

public class SeasonTest {
	
	public SeasonTest(Season s) {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(s.getName()+"是一个"+s.getDesc()+"的季节");
	}

	public static void main(String[] args) {
		new SeasonTest(Season.SPRING);
	}
}
