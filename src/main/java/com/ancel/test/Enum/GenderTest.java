package com.ancel.test.Enum;

public class GenderTest {
	public static void main(String[] args) {
		Gender g = Enum.valueOf(Gender.class, "FEMALE");
		System.out.println(g.name());
		g.setName("女");
		System.out.println(g + "代表" +g.getName());
		g.setName("男");
		System.out.println(g + "代表" +g.getName());
	}
}
