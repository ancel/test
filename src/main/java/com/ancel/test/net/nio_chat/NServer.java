package com.ancel.test.net.nio_chat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NServer {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 30000;
	
	//用于检测所有channel状态的selector
	private Selector selector = null;
	//实现编码和解码的字符集对象
	private Charset charset = Charset.forName("utf-8");
	
	public void init() throws Exception{
		selector = Selector.open();
		//通过open方法打开一个未绑定的serversocketchannel实例
		ServerSocketChannel server = ServerSocketChannel.open();
		InetSocketAddress isa = new InetSocketAddress(IP, PORT);
		//绑定
		server.socket().bind(isa);
		//设置为非阻塞方式工作
		server.configureBlocking(false);
		//将server注册到指定selector对象
		server.register(selector, SelectionKey.OP_ACCEPT);
		while(selector.select()>0){
			System.out.println(selector.selectedKeys().size());
			//以此处理selector上的每个已选择的selectionkey
			for(SelectionKey sk:selector.selectedKeys()){
				//从selector上的已选择key集中删除正在处理的selectionkey
				selector.selectedKeys().remove(sk);
				//如果sk对应的通道包含客户端的连接请求
				if(sk.isAcceptable()){
					//调用accept方法接受连接，产生服务器对应的socketchannel
					SocketChannel sc = server.accept();
					//设置使用非阻塞模式
					sc.configureBlocking(false);
					//将该socketchannel也注册到selector上
					sc.register(selector, SelectionKey.OP_READ);
					//将sk对应的channel设置成准备接受其他请求
					sk.interestOps(SelectionKey.OP_ACCEPT);
					System.out.println("--------------client连接成功");
					
				}
				//如果sk对应的通道有数据需要读取
				if(sk.isReadable()){
					//获取该selectionkey对应的channel，该channel中有可读的数据
					SocketChannel sc = (SocketChannel) sk.channel();
					//定义准备读取数据的bytebuffer
					ByteBuffer buff = ByteBuffer.allocate(1024);
					String content = "";
					//开始读取数据
					try {
						while(sc.read(buff)>0){
							buff.flip();
							content +=charset.decode(buff);
						}
						//打印从该sk对应的channel里读取的数据
						System.out.println("======="+content);
						//将sk对应的channel设置成准备下一次读取
						sk.interestOps(SelectionKey.OP_READ);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//从selector中删除指定selectionkey
						sk.cancel();
						if(sk.channel()!=null){
							sk.channel().close();
						}
					}
					if(content.length()>0){
						//遍历selector中注册的所有selectkey
						for(SelectionKey key:selector.keys()){
							//获取该key对应的channel
							Channel targetChannel = key.channel();
							if(targetChannel instanceof SocketChannel){
								//将读的内容写入到该channel中
								SocketChannel dest = (SocketChannel) targetChannel;
								dest.write(charset.encode(content));
							}
						}
					}
				}
				System.out.println("删除之后"+selector.selectedKeys().size());
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		try {
			new NServer().init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
