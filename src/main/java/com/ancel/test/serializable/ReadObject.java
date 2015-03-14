package com.ancel.test.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
	public static void main(String[] args) {
		 ObjectInputStream ois = null;
		 try {
			ois = new ObjectInputStream(new FileInputStream("d:/object.txt"));
			Person person = (Person) ois.readObject();
			Teacher t1 = (Teacher) ois.readObject();
			Teacher t2 = (Teacher) ois.readObject();
			Teacher t3 = (Teacher) ois.readObject();
			System.out.println(person.getName()+"的年龄是"+person.getAge());
			System.out.println("t1的student引用和person相同吗？"+(person==t1.getStudent()));
			System.out.println("t2的student引用和person相同吗？"+(person==t2.getStudent()));
			System.out.println("t1和t3是同一个对象吗？"+(t1==t3));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
