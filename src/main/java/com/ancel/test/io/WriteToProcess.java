package com.ancel.test.io;

import java.io.IOException;
import java.io.PrintStream;

public class WriteToProcess {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			//返回运行该命令的子进程
			Runtime.getRuntime().exec("cmd.exe");
			Process  p = Runtime.getRuntime().exec("java ReadStandard");
			//以p的输出流创建printstream对象
			//这个输出流对本程序是输出流，对p进程是输入流
			ps = new PrintStream(p.getOutputStream());
			ps.print("普通字符串\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ps!=null){
				ps.close();
			}
		}
	}
}
