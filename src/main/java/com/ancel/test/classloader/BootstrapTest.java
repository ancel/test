package com.ancel.test.classloader;

import java.net.URL;

import sun.misc.Launcher;

public class BootstrapTest {
	public static void main(String[] args) {
		//获取根类加载器所加载的全部url数组
		URL[] urls = Launcher.getBootstrapClassPath().getURLs();
		for(URL url: urls){
			System.out.println(url.toExternalForm());
		}
	}
}
