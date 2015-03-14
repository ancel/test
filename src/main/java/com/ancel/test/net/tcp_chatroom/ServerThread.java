package com.ancel.test.net.tcp_chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable{

	private Socket s = null;
	private BufferedReader br = null;
	
	public ServerThread(Socket s) throws IOException {
		super();
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		PrintStream ps = null;
		try {
			String content = null;
			while((content = readFromClient())!=null){
				for(Socket s:MyServer.socketList){
					ps = new PrintStream(s.getOutputStream());
					ps.println(content);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ps.close();
		}
	}

	private String readFromClient(){
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			MyServer.socketList.remove(s);
		}
		return null;
	}
}
