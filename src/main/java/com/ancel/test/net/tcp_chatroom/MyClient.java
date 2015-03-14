package com.ancel.test.net.tcp_chatroom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClient {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 30000;
	
	public static void main(String[] args) {
		Socket s = null;
		PrintStream ps = null;
		try {
			s = new Socket(IP,PORT);
			new Thread(new ClientThread(s)).start();
			ps = new PrintStream(s.getOutputStream());
			String line = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while((line = br.readLine())!=null){
				ps.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ps.close();
			try {
				s.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
