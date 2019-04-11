package com.io.file;

import java.io.File;

public class FileTest2 {

	public static void main(String[] args) {

		File file = new File("C:\\");
		// list
		// 파일이면 해당 파일의 크기를 출력
		// 폴더라면 폴더 입니다. 출력

		String[] str = file.list();

		for (int i = 0; i < str.length; i++) {

			File file2 = new File(file + str[i]);
			
		
			if (file2.isFile()) {

				System.out.println("파일명 : " + file2.getName());
				System.out.println("파일의 크기 : " + file2.length());
				System.out.println();

			} else if (file2.isDirectory()) {

				System.out.println("파일명 : " + file2.getName());
				System.out.println("폴더입니다.");
				System.out.println();
				
			} else {

				System.out.println("해당 파일 또는 폴더가 존재하지 않습니다.");

			}
		}

		
		File[] lists = file.listFiles(); //파일 객체로 받아오는 것
		
	}

}
