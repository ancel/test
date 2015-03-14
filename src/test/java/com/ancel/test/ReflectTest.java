package com.ancel.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {
	public ReflectTest(){
		System.out.println("null");
	}
	
	public ReflectTest(Integer a){
		System.out.println(a);
	}
	
	public void say(){
		System.out.println("hello");
	}
	
	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("com.ancel.test.ReflectTest");
			Constructor<?>  cst = cls.getConstructor(Integer.class);
			ReflectTest r = (ReflectTest)cst.newInstance(2);
			r.say();
			Constructor<?> cst2 = cls.getConstructor();
			cst2.newInstance(); 
			
			ReflectTest r2 = (ReflectTest)cls.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
