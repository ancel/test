package com.ancel.test;

public class Test {
	
	public static int m;
	static{
		System.out.println("nihao ");
	}
	
	public static void main(String[] args) {
		System.out.println(Test.m);
		System.out.println(Test.m);
		Son son = new Son();
	}
	
	static void setU(User user){
		user.setName("xuwei");
		user = new User();
		user.setName("wanghaibo");
	}
	
	void f1(User user){
		user.setName("xuwei");
		user.setAge(23);
	}
	
	int f(int i){
		return ++i;
	}
}
class User{
	String name;
	int age;
	public User(){};
	public User(String name,int age){
		this.name=name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
