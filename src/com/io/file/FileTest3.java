package com.io.file;

import java.io.File;
import java.util.StringTokenizer;

public class FileTest3 {

	public static void main(String[] args) {
		
		File file = new File("c:\\test");
		String str = "iu-suji-choa,hani";
		str = str.replace(",", "-");
		String[] arr = str.split("-");
		
		for (int i = 0; i < arr.length; i++) {
			
			
			System.out.println(arr[i]);
			file = new File("c:\\test\\" + arr[i]);
			file.mkdirs();
			
		}
		

	}

}
