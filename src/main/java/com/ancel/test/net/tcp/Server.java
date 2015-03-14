package com.ancel.test.net.tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket ss = null;
		PrintStream ps = null;
		try {
			ss = new ServerSocket(30000);
			while(true){
				Socket s = ss.accept();
				ps = new PrintStream(s.getOutputStream());
				ps.println("您好，您收到了服务器的祝福");
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ps.close();
		}
	}
}
