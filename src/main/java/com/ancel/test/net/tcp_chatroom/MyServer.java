package com.ancel.test.net.tcp_chatroom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {
	public static final int PORT = 30000;
	public static ArrayList<Socket> socketList = new ArrayList<Socket>();
	
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(PORT);
			while(true){
				Socket s = ss.accept();
				socketList.add(s);
				new Thread(new ServerThread(s)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ss!=null){
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
