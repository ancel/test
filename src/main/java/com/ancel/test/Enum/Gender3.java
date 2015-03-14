package com.ancel.test.Enum;

public enum Gender3 implements GenderDesc{
	MALE("男"){
		@Override
		public void info() {
			// TODO Auto-generated method stub
			System.out.println("我是"+getName()+"人");
		}
	},FEMALE("女"){
		@Override
		public void info() {
			// TODO Auto-generated method stub
			System.out.println("我是"+getName()+"人");
		}
	};
	
	private String name;
	private Gender3(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("我是人");
	}

}
