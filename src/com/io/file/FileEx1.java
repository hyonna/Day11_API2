package com.io.file;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class FileEx1 {

	public void ex1() {

		// 1. c:\\test\\iu 디렉터리 내에 이미지 파일을 제외한 모든 파일을 삭제
		// 확장자, bmp, jpg, gif, png

		File file = new File("c:\\test\\iu");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("bmp", "img");
		map.put("jpg", "img");
		map.put("gif", "img");
		map.put("png", "img");
		
		
		String[] names = file.list();

		
		for (int i = 0; i < names.length; i++) {

			int index = names[i].lastIndexOf('.');
			String n = names[i].substring(index + 1);
			
			if(!(map.get(n) != null && map.get(n).equals("img"))) {
				
				File file2 = new File(file, names[i]);
				file2.delete();
				
			}
			
		}

	}
	
	
	
	public void ex2() {
		
//		2. 스캐너를 이용해서 디렉터리명을 입력
//		c:\\test
//		입력한 디렉터리가 있으면 삭제, 없으면 만들기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("폴더명 입력");
		String name = sc.next();
		
		File file = new File("c:\\test", name);
		
		if(file.exists()) {
			
			file.delete();
			
		} else {
			
			file.mkdir();
		}
		
		
		
	}
	
	public void ex3() {
		
//		3. c:\\test
//		디렉터리 생성 단, 중복되는 이름이 없도록
//		파일명이 해당폴더내에 같은 이름이 없다는것이 보증
		
		//Calendar
		
		String filename = "";
		Calendar ca = Calendar.getInstance();
		
		long t = ca.getTimeInMillis();
		filename = "D" + t;
		File file = new File("c:\\test\\" , filename);
		file.mkdir();
		
		
		
	}

}
