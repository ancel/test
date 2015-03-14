package com.ancel.test.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("d:/object.txt"));
			Person person = new Person("孙悟空", 500);
			oos.writeObject(person);

			ois = new ObjectInputStream(new FileInputStream("d:/object.txt"));
			Person p1 = (Person) ois.readObject();
			System.out.println(p1.getAge());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
