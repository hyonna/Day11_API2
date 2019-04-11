package com.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ServerTest3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ServerSocket ss = null;
		Socket s = null;
		FileReader fr = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		InputStream is = null;
		InputStreamReader ir = null;
		File file1 = new File("c:\\test", "lunch.txt");
		File file2 = new File("c:\\test", "dinner.txt");
		OutputStream os = null;
		OutputStreamWriter ow = null;
		//ArrayList<String> menusArr = new ArrayList<String>();
		
		Random r = new Random();

		try {

			System.out.println("Server : 클라이언트 접속 준비중");
			ss = new ServerSocket(8180);
			s = ss.accept();
			System.out.println("Server : 연결 성공");

			// -------------------------------------

			fr = new FileReader(file1);
			br = new BufferedReader(fr);

			String str = br.readLine();

			String[] menus = str.split(",");

			int index = r.nextInt(menus.length);
			str = menus[index];

			

			// -----------------------------------

			fr = new FileReader(file2);
			br = new BufferedReader(fr);

			String str2 = br.readLine();

			String[] menus2 = str2.split(",");

			int index2 = r.nextInt(menus2.length);
			str2 = menus2[index];

			// -----------------------------------

			
			String num = str + str2;
			
			String[] menus3 = num.split(",");

			int index3 = r.nextInt(menus3.length);
			num = menus3[index];


			
//			// -----------------------------------
//
//			os = s.getOutputStream();
//			ow = new OutputStreamWriter(os);
//			bw = new BufferedWriter(ow);
//			System.out.println("클라이언트로 보낼 메세지 입력");
//			String message = sc.next();
//
//			bw.write("클라이언트에게 보내는 메세지 : " + message);
//			bw.write("\r\n");
//			bw.flush();

			// -----------------------------------

			
			
			is = s.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);

			String clientM = br.readLine();
			
			os = s.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);

			if (clientM.equals("lunch")) {

				System.out.println(str);
				bw.write("점심메뉴 : " + str);
				bw.write("\r\n");
				bw.flush();
			

			} else if (clientM.equals("dinner")) {

				System.out.println(str2);
				bw.write("저녁메뉴 : " + str2);
				bw.write("\r\n");
				bw.flush();
				
			} else {

				System.out.println(num);
				bw.write("아무메뉴 : " + num);
				bw.write("\r\n");
				bw.flush();
			}
			
			

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				bw.close();
				ow.close();
				os.close();
				br.close();
				ir.close();
				is.close();
				s.close();
				ss.close();

			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

}
