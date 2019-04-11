package com.io.file;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		
		
		File file = new File("C:\\test\\ex1.txt");
		file = new File("C:\\test", "ex1.txt");
		file = new File("C:\\test");
		File file2 = new File(file, "ex1.txt");
		
		System.out.println(file.exists()); //파일이 존재하는 지 여부 확인 메소드
		System.out.println(file.isDirectory()); //테스트 까지의 경로가 폴더인지 확인
		System.out.println(file.isFile()); //파일인지 아닌지 확인
		System.out.println(file.canExecute()); //실행할 수 있는 파일인지 확인
		System.out.println(file.getName()); //파일명 출력
		System.out.println(file.getParent()); //파일의 부모 경로
		System.out.println(file.length()); //파일의 크기
		/*
		 * file.createNewFile(); // -> 빈 파일 만들기
		 */		
		
		File f = new File("c:\\");
		String[] str = f.list(); //'이름'만 가져오는 것
		File[] lists = file.listFiles(); //'파일' 객체로 받아오는 것
		
		for (int i = 0; i < str.length; i++) {
			
			System.out.println(str[i]);
			
			
			
		}
		
		file = new File("c:\\test\\test2");
		file.mkdir();
		
		file = new File("c:\\test\\iu\\test");
		file.mkdirs(); //없는 폴더를 만들어줌
		
		
		file = new File("c:\\test\\test2\\iu");
		file.delete();
		
	}

}
