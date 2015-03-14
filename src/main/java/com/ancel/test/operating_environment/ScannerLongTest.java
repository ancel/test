package com.ancel.test.operating_environment;

import java.util.Scanner;

public class ScannerLongTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//scan.useDelimiter("\n");
		while(scan.hasNextLong()){
			System.out.println(scan.nextLong());
		}
	}
}
