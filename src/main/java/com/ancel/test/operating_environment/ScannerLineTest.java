package com.ancel.test.operating_environment;

import java.util.Scanner;

public class ScannerLineTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//scan.useDelimiter("\n");
		while(scan.hasNextLine()){
			System.out.println(scan.next());
		}
	}
}
