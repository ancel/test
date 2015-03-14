package com.ancel.test.net.tcp_chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable{
	private Socket s;
	private BufferedReader br;
	
	public ClientThread(Socket s) throws IOException {
		super();
		this.s = s;
		this.br = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String content = null;
			while((content = br.readLine())!=null){
				System.out.println(content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
