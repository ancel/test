package com.ancel.test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookFacadeProxy implements InvocationHandler{
	private Object target;  
    /** 
     * 绑定委托对象并返回一个代理类 
     * @param target 
     * @return 
     */  
    public Object bind(Object target) {  
        this.target = target;  
        //取得代理对象  
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),  
                target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)  
    }  
  
    @Override  
    /** 
     * 调用方法 
     */  
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
    	System.out.println(proxy.getClass().getCanonicalName());
        Object result=null;  
        if(method.getName().equals("addBook")){
        	 System.out.println("事物开始");  
             //执行方法  
             result=method.invoke(target, args);  
             System.out.println("事物结束");
        }else{
        	System.out.println("该方法不执行");
        }
         
        return result;  
    }  
}
