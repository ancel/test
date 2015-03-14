package com.ancel.test.net.nio_chat;

import java.nio.channels.Selector;
/*
 * 再大的应用也只需要一个selector就够了
 */
public class SelectorTest {
	private static final int MAXSIZE = 65535;
	public static void main(String[] args) {
		Selector[] sels = new Selector[MAXSIZE];
		int i = 0;
		try {
			for(;i<MAXSIZE;i++){
				sels[i] = Selector.open();
			}
			Thread.sleep(300000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(i);
			e.printStackTrace();
		}
	}
}
