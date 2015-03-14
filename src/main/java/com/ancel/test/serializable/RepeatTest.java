package com.ancel.test.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RepeatTest {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("d:/object.txt"));
			
			
			Person person = new Person("悟空",500);
			oos.writeObject(person);
			person.setName("八戒");
			oos.writeObject(person);
			
			ois = new ObjectInputStream(new FileInputStream("d:/object.txt"));
			Person p1 = (Person) ois.readObject();
			Person p2 = (Person) ois.readObject();
			System.out.println(p1==p2);
			System.out.println(p2.getName());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
