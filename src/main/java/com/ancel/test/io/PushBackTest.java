package com.ancel.test.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushBackTest {
	public static void main(String[] args) {
		PushbackReader pr = null;
		try {
			pr = new PushbackReader(new FileReader("D:/test.txt"),18);
			char[] buf = new char[32];
			String lastContent = "";
			int hasRead = 0;
			while((hasRead = pr.read(buf))>0){
				String content = new String(buf,0,hasRead);
				int targetIndex = 0;
				if((targetIndex = (lastContent+content).indexOf("流"))>0){
					pr.unread((lastContent+content).toCharArray());
					pr.read(buf,0,targetIndex);
					System.out.println(new String(buf,0,targetIndex));
					System.exit(0);
				}else{
					System.out.println(lastContent);
					lastContent = content;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pr!=null){
				try {
					pr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
