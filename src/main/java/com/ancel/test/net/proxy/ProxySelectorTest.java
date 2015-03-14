package com.ancel.test.net.proxy;

import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;
/*
 * 需要代理服务器
 */
public class ProxySelectorTest {
	/*
	 * 测试本地jvm的网络默认配置
	 */
	public void setLocalProxy(){
		Properties prop = System.getProperties();
		//设置代理服务器访问的地址
		prop.setProperty("http.proxyHost", "127.0.0.1");
		//设置代理服务器端口
		prop.setProperty("http.proxyPort", "8080");
		//设置http访问不需要通过代理服务器
		//可使用*通配符，使用|分割多个地址
		prop.setProperty("http.nonProxyHosts", "localhost|10.20.*");
		
		//设置安全访问的地址和端口
		prop.setProperty("https.proxyHost", "localhost");
		prop.setProperty("https.proxyPort", "8080");
		
		prop.setProperty("ftp.proxyHost", "localhost");
		prop.setProperty("ftp.proxyPort", "8080");
		
		prop.setProperty("socks.proxyHost", "localhost");
		prop.setProperty("socks.proxyPort", "8080");

	}
	
	/*
	 * 清楚proxy配置
	 */
	public void removeLocalProxy(){
		Properties prop = System.getProperties();
		//设置代理服务器访问的地址
		prop.remove("http.proxyHost");
		//设置代理服务器端口
		prop.remove("http.proxyPort");
		//设置http访问不需要通过代理服务器
		//可使用*通配符，使用|分割多个地址
		prop.remove("http.nonProxyHosts");
		
		//设置安全访问的地址和端口
		prop.remove("https.proxyHost");
		prop.remove("https.proxyPort");
		
		prop.remove("ftp.proxyHost");
		prop.remove("ftp.proxyPort");
		
		prop.remove("socks.proxyHost");
		prop.remove("socks.proxyPort");
	}
	
	//测试http访问
	public void showHttpProxy(){
		try {
			URL url = new URL("http://www.baidu.com");
			//直接打开，但是系统会调用刚才设置的http代理服务器
			URLConnection conn = url.openConnection();
			Scanner scan = new Scanner(conn.getInputStream());
			while(scan.hasNextLine()){
				System.out.println(scan.nextLine());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ProxySelectorTest test = new ProxySelectorTest();
		test.setLocalProxy();
		test.showHttpProxy();
		test.removeLocalProxy();
	}
}
