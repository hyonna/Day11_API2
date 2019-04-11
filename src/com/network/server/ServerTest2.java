package com.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTest2 {

	public static void main(String[] args) {
		
		ServerSocket ss =null;
		Socket sc = null;
//		InputStream is = null;
//		InputStreamReader ir = null;
//		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			
			
			System.out.println("Server : 클라이언트 접속 준비중");
			ss = new ServerSocket(8180);
			sc = ss.accept();
			System.out.println("Server : 연결 성공");
			System.out.println("================");
			System.out.println("사람 이름을 입력하세요");
			String name = scan.next();
			
			String[] names = name.split("-");
			
			String nNum = null;
			
			for(int i = 0; i < names.length; i++) {
				
				nNum = names[i];
				
			}
			
			System.out.println("선택된 사람 : " + nNum);
			
			os = sc.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);

			bw.write(nNum);
			bw.write("\r\n");
			bw.flush();
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {

			try {

//				br.close();
//				ir.close();
//				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
				ss.close();

			} catch (IOException e) {

				e.printStackTrace();
			}

		
		}

	}

}
