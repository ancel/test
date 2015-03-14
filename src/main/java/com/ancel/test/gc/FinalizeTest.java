package com.ancel.test.gc;

public class FinalizeTest {
	private static FinalizeTest ft = null;
	public void info(){
		System.out.println("测试资源清理的方法finalize");
	}
	public static void main(String[] args) {
		//创建对象并立即进入去活状态
		new FinalizeTest();
		//通知系统进行资源回收
		System.gc();
		//线程睡眠之后，垃圾回收机制启动。ft被引用到堆内存中的对象
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Runtime和System都提供了强制调用finalize方法
		Runtime.getRuntime().runFinalization();
		//System.runFinalization();
		ft.info();
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		ft = this;
	}
	
}
