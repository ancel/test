package com.ancel.test.dynamicproxy;



  
public class TestProxy {  
	enum fangxiang{
		west,east,north,south
	}
  
    public static void main(String[] args) {  
        BookFacadeProxy proxy = new BookFacadeProxy();  
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());  
        bookProxy.addBook();
        //bookProxy.deleteBook();
    }  
    
    
}  
