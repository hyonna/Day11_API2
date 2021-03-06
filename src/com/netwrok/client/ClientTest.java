package com.netwrok.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTest {

	public static void main(String[] args) {

		Socket s = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner sc = new Scanner(System.in);
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;

		try {

			s = new Socket("127.0.0.1", 8180);
			System.out.println("서버와 접속 성공");

			while (true) {

				os = s.getOutputStream(); // byte
				ow = new OutputStreamWriter(os); // char
				bw = new BufferedWriter(ow);
				System.out.println("서버로 보낼 메세지 입력");
				String str = sc.next();
				bw.write(str);
				bw.write("\r\n");
				bw.flush();

				if (str.equals("end")) {

					System.out.println("종료합니다");
					break;
				}

				is = s.getInputStream(); // byte
				ir = new InputStreamReader(is); // char
				br = new BufferedReader(ir);

				str = br.readLine();
				System.out.println("Message : " + str);

				if (str.equals("end")) {

					System.out.println("종료합니다");
					break;
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				bw.close();
				ow.close();
				os.close();
				s.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		System.out.println("Client 종료");

	}

}
