package com.ancel.test.dynamicproxy;

public class BookFacadeImpl implements BookFacade{

	public void addBook() {
		// TODO Auto-generated method stub
		System.out.println("添加图书");
	}

	@Override
	public void deleteBook() {
		// TODO Auto-generated method stub
		System.out.println("删除图书");
	}
}
