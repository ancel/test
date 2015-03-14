package com.ancel.test;

public class Son extends Father{
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) {
		//pass
		Father s = new Son();
		//Father f2 = (Father)s;
		Son ss = (Son)s;
		
		//no pass
//		Father f3 = new Father();
//		Son s2 = (Son)f3;
		
		//
		Son s3 = new Son();
		Father f4 = (Father)s3;
	}
}
