package com.io;

import java.io.IOException;
import java.io.InputStream;

public class IoTest1 {

	public static void main(String[] args) {

		System.out.println("입력");
		InputStream is = System.in;
		// read 메서드

		try {
			
			int num = is.read(); //1byte만 읽어들임
			System.out.println((char)num);

		} catch (IOException e) {

			e.printStackTrace();
		}

		
		System.out.println("종료");
	}

}
