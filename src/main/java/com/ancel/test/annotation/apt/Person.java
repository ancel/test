package com.ancel.test.annotation.apt;

@Persistent(table="person")
public class Person {
	@IdProperty(column="id",type="integer",generator="identity")
	private int id;
	@Property(column="name",type="string")
	private String name;
	@Property(column="age",type="integer")
	private int age;
	
	
	private Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
