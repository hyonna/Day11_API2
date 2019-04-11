package com.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IoTest2 {

	public static void main(String[] args) {

		// 키보드로 부터 받은 문자열을 출력
		// byte로 받아서
		// byte - > 문자
		// 문자 -> 문자열

		System.out.println("입력");

		InputStream is = System.in; // byte
		InputStreamReader ir = new InputStreamReader(is); // 문자를 처리
		BufferedReader br = new BufferedReader(ir);

		//Scanner 가 돌아가는 원리
		
		try {

			String str = br.readLine();
			System.out.println(str);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				br.close();
				ir.close();
				is.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

}
