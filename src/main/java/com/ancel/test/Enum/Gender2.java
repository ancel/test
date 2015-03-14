package com.ancel.test.Enum;

public enum Gender2 {
	MALE("男"),FEMALE("女");
	private String name;
	private Gender2(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
