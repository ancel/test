package com.ancel.test.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
	public static void main(String[] args) {
		BufferedReader br = null;
		InputStreamReader isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		String buffer = null;
		try {
			while ((buffer = br.readLine()) != null) {
				if (buffer.equals("exit")) {
					System.exit(1);
				}
				System.out.println(buffer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
