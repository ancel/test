package com.ancel.test.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
	private static final String DEST_IP = "127.0.0.1";
	private static final int DEST_PORT = 30000;
	// 定义每个数据包的大小4K
	private static final int DATA_LEN = 4096;
	// 定义客户端使用的socket
	private DatagramSocket socket = null;
	// 定义接受网络数据的额字符数组
	byte[] inBuff = new byte[DATA_LEN];
	// 以指定字节数组创建准备接收数据的datagrampacket对象
	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
	// 定义一个用于发送的datagrampacket对象
	private DatagramPacket outPacket;
	
	public void init(){
		try {
			socket = new DatagramSocket();
			outPacket = new DatagramPacket(new byte[0], 0, InetAddress.getByName(DEST_IP), DEST_PORT);
			
			Scanner scan = new Scanner(System.in);
			while(scan.hasNextLine()){
				byte[] buff = scan.nextLine().getBytes();
				outPacket.setData(buff);
				socket.send(outPacket);
				socket.receive(inPacket);
				System.out.println(new String(inBuff,0,inPacket.getLength()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(socket!=null){
				socket.close();
			}
		}
	}
	
	public static void main(String[] args) {
		new UdpClient().init();
	}
}
