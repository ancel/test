package com.ancel.test.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Apple<T> {
	//错误的申明，不能再静态属性中申明使用类型参数
	//static T a;
	private T info;

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	private Apple(T info) {
		super();
		this.info = info;
	}
	
	public Apple() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public static void main(String[] args) {
		Apple<String> a1 = new Apple<String>("String");
		System.out.println(a1.getInfo());
		
		Apple<Double> a2 = new Apple<Double>(2.56);
		System.out.println(a2.getInfo());
		
		//返回true，无论泛型的实际参数是什么，在运行期它们总是同样的类
		System.out.println(a1.getClass()==a2.getClass());
		
		Collection<String> c = new ArrayList<String>();
		System.out.println(c instanceof List);
		//错误的格式
		//System.out.println(c instanceof List<String>);
		
		
	}
}
