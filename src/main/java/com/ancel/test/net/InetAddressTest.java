package com.ancel.test.net;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) {
		try {
			
			InetAddress ip  = InetAddress.getByName("sz13021797");
			//判断是否可达
			System.out.println("baidu是否可达："+ip.isReachable(2000));
			
			System.out.println(ip.getHostAddress());
			
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("本机是否可达："+local.isReachable(2000));
			
			//获取全限定域名
			System.out.println(local.getCanonicalHostName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
