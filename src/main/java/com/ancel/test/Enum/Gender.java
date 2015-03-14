package com.ancel.test.Enum;

public enum Gender {
	MALE,FEMALE;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		switch(this){
		case MALE:
			if(name.equals("男")){
				this.name="男";
			}else{
				System.out.println("参数错误");
				return;
			}
			break;
		case FEMALE:
			if(name.equals("女")){
				this.name="女";
			}else{
				System.out.println("参数错误");
				return;
			}
			break;
		}
	}
	
}
