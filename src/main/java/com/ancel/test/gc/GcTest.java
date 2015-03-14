package com.ancel.test.gc;

public class GcTest {
	public static void main(String[] args) {
		for(int i=0;i<4;i++){
			new GcTest();
		}
		Runtime.getRuntime().gc();
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("系统正在清理垃圾资源…………");
	}
}
