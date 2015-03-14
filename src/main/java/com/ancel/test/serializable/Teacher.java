package com.ancel.test.serializable;

import java.io.Serializable;

public class Teacher implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String name;
	private Person student;
	public Teacher(String name, Person student) {
		super();
		this.name = name;
		this.student = student;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person getStudent() {
		return student;
	}
	public void setStudent(Person student) {
		this.student = student;
	}
	
}
