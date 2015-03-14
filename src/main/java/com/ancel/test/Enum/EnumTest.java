package com.ancel.test.Enum;

public class EnumTest {
	public void judge(SeasonEnum se){
		switch(se){
		case SPRING:
			System.out.println("春天到了");
			break;
		case SUMMER:
			System.out.println("夏天到了");
			break;
		case FALL:
			System.out.println("秋天到了");
			break;
		case WINTER:
			System.out.println("冬天到了");
			break;
		default:
			break;
		}
	}
	
	public static void main(String[] args) {
		EnumTest et = new EnumTest();
		for(SeasonEnum se: SeasonEnum.values()){
			et.judge(se);
		}
	}
}
