package com.ancel.test.collection;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		String[] books = {"struts2","spring","hibernate"};
		//返回定长list
		//List bookList  = Arrays.asList(books);
		ArrayList list = new ArrayList();
		//一次性分配100个位置
		//list.ensureCapacity(100);
		//调整集合大小为当前列表大小
		//list.trimToSize();
		for(int i=0;i<books.length;i++){
			list.add(books[i]);
		}
		
		
		ListIterator li = list.listIterator();
		while(li.hasNext()){
			
			System.out.println(li.next());
			li.add("asdf");
			
		}
		System.out.println("……………………………………");
		while(li.hasPrevious()){
			System.out.println(li.previous());
		}
	}
}
