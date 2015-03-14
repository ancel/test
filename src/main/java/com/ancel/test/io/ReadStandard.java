package com.ancel.test.io;

import java.io.PrintStream;
import java.util.Scanner;

public class ReadStandard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			PrintStream ps = new PrintStream("D:/readstandard.txt");
			sc.useDelimiter("\n");
			while(sc.hasNext()){
				ps.write(sc.next().getBytes());
			}
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
