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

public class ServerTest3_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ServerSocket ss = null;
		Socket s = null;
		FileReader fr = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		InputStream is = null;
		InputStreamReader ir = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		ServerMenu sm = new ServerMenu();

		try {

			sm.init();
			System.out.println("Server : 클라이언트 접속 준비중");
			ss = new ServerSocket(8180);
			s = ss.accept();
			System.out.println("Server : 연결 성공");

			
			is = s.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);

			String check = br.readLine();
			
			if(check.equals("1")) {
				
				check = sm.getLunch();
				
			} else if(check.equals("2")) {
				
				check = sm.getDinner();
				
			} else {
				
				check = "준비중";
				
			}
			
			
			System.out.println(check);
			
			os = s.getOutputStream(); // byte
			ow = new OutputStreamWriter(os); // char
			bw = new BufferedWriter(ow);
			
			bw.write(check + "\r\n");
			bw.flush();
			

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				
				br.close();
				ir.close();
				is.close();
				ow.close();
				os.close();
				s.close();
				ss.close();

			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

}
