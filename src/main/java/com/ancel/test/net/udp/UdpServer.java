package com.ancel.test.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
	private static final int PORT = 30000;
	// 定义每个数据包的大小4K
	private static final int DATA_LEN = 4096;
	// 定义服务器使用的socket
	private DatagramSocket socket = null;
	// 定义接受网络数据的额字符数组
	byte[] inBuff = new byte[DATA_LEN];
	// 以指定字节数组创建准备接收数据的datagrampacket对象
	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
	// 定义一个用于发送的datagrampacket对象
	private DatagramPacket outPacket;
	// 定义一个字符数组，服务器发送该数组元素
	String[] books = new String[] { "java", "struts", "spring", "hibernate" };
	
	public void init(){
		try {
			socket = new DatagramSocket(PORT);
			
			//循环接受数据
			for(int i=0;i<1000;i++){
				//读取socket的数据，将数据放在inpacket所封装的数组里
				socket.receive(inPacket);
				//判断inpacket.getdata()和inbuff是否是同一个数组
				System.out.println(inBuff==inPacket.getData());
				//将接收到的内容转成字符串后输出
				System.out.println(new String(inBuff, 0,inPacket.getLength()));
				//从字符数组中取出第一个元素作为发送的数据
				byte[] sendData = books[i%4].getBytes();
				//以指定字节数组发送数据，
				//以刚接收到的datagrampacket源socketaddress作为目标socketaddress创建datagrampacket]
				outPacket = new DatagramPacket(sendData, sendData.length, inPacket.getSocketAddress());
				//发送数据
				socket.send(outPacket);
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
		new UdpServer().init();
	}
}
