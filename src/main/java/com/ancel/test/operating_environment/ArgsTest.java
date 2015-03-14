package com.ancel.test.operating_environment;

public class ArgsTest {
	public static void main(String[] args) {
		System.out.println(args.length);
		for(String arg:args){
			System.out.println(arg);
		}
	}
}
