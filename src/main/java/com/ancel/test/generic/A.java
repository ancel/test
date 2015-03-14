package com.ancel.test.generic;


/*
 * Apple必须要有默认的构造方法，否则无法继承，若要传入T则必须为实际类型，否则不用规定泛型
 */
public class A extends Apple<String>{
	
}
