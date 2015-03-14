package com.ancel.test.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("d:/object.txt"));
			Person person = new Person("孙悟空", 500) ;
			oos.writeObject(person);
			
			Teacher t1 = new Teacher("唐僧", person);
			Teacher t2 = new Teacher("菩提祖师", person);
			oos.writeObject(t1);
			oos.writeObject(t2);
			oos.writeObject(t1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
