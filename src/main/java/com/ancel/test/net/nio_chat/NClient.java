package com.ancel.test.net.nio_chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class NClient {
	
	public static final String IP = "127.0.0.1";
	public static final int PORT = 30000;
	
	//定义检测socketchannel的selector对象
	private Selector selector = null;
	//定义处理编码和解码的字符集
	private Charset charset = Charset.forName("utf-8");
	//客户端socketchannel
	private SocketChannel sc = null;
	
	public void init() throws Exception{
		selector = Selector.open();
		InetSocketAddress isa = new InetSocketAddress(IP, PORT);
		//绑定
		sc = SocketChannel.open(isa);
		//设置为非阻塞方式工作
		sc.configureBlocking(false);
		//将server注册到指定selector对象]
		sc.register(selector, SelectionKey.OP_READ);
		
		new ClientThread().start();
		
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			sc.write(charset.encode(scan.nextLine()));
		}
	}
	
	private class ClientThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(selector.select()>0){
					System.out.println(selector.selectedKeys().size());
					//遍历每个有可用io操作channel对应的selectionkey
					for(SelectionKey sk : selector.selectedKeys()){
						//从selector上的已选择key集中删除正在处理的selectionkey
						selector.selectedKeys().remove(sk);
						//如果selectionkey对应的channel中有可读数据
						if(sk.isReadable()){
							//使用nio读取channel中的数据
							SocketChannel sc = (SocketChannel)sk.channel();
							ByteBuffer buff = ByteBuffer.allocate(1024);
							String content = "";
							while(sc.read(buff)>0){
								sc.read(buff);
								buff.flip();
								content += charset.decode(buff);
							}
							System.out.println("聊天信息"+content);
							//为下次读取做准备
							sk.interestOps(SelectionKey.OP_READ);
						}
						System.out.println(selector.selectedKeys().size());
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		try {
			new NClient().init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
