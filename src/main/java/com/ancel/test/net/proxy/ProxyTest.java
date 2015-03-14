package com.ancel.test.net.proxy;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
/*
 * 需要拥有代理服务器****************
 */

public class ProxyTest {
	Proxy proxy;
	URL url;
	URLConnection conn;
	//从网络读取代理数据
	Scanner scan;
	PrintStream ps;
	String proxyAddress = "127.0.0.1";
	int proxyPort = 8080;
	//打开的网址
	String urlStr = "http://wps.wondershare.cn";
	public void init(){
		try {
			url = new URL(urlStr);
			//创建一个代理服务器对象
			proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyAddress, proxyPort));
			//使用指定服务器打开连接
			conn = url.openConnection(proxy);
			//设置超时时长
			conn.setConnectTimeout(5000);
			scan = new Scanner(conn.getInputStream());
			ps = new PrintStream("D:/test/index.htm");
			
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				System.out.println(line);
				ps.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ps!=null){
				ps.close();
			}
		}
	}
	
	public static void main(String[] args) {
		new ProxyTest().init();
	}
}
