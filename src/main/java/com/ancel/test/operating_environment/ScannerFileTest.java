package com.ancel.test.operating_environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileTest {
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("D:/io.ini"));
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
