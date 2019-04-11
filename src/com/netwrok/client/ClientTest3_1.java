package com.netwrok.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest3_1 {

	public static void main(String[] args) {

		Socket sk = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner sc = new Scanner(System.in);
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;

		try {

			sk = new Socket("127.0.0.1", 8180);
			System.out.println("서버와 접속 성공");
			System.out.println("1. lunch \t 2. dinner \t 3. all");
			int select = sc.nextInt();
			

			// -----------------------------------
			
			os = sk.getOutputStream(); // byte
			ow = new OutputStreamWriter(os); // char
			bw = new BufferedWriter(ow);
			
			bw.write(select+"\r\n");
			bw.flush();
			
			// -----------------------------------

			is = sk.getInputStream(); // byte
			ir = new InputStreamReader(is); // char
			br = new BufferedReader(ir);

			String st = br.readLine();
			System.out.println("Message : " + st);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				br.close();
				ir.close();
				is.close();
				ow.close();
				os.close();
				sk.close();


			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		System.out.println("Client 종료");

	}

}
