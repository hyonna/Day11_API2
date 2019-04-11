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
import java.nio.Buffer;
import java.util.Scanner;

public class ServerTest {

	public static void main(String[] args) {

		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner ssc = new Scanner(System.in);

		try {

			System.out.println("Server : 클라이언트 접속 준비중");
			ss = new ServerSocket(8180);
			sc = ss.accept();
			System.out.println("Server : 연결 성공");

			while (true) {

				is = sc.getInputStream(); // byte
				ir = new InputStreamReader(is); // char
				br = new BufferedReader(ir);

				String s = br.readLine();

				if (s.equals("end")) {

					System.out.println("종료합니다");
					break;
				}
				System.out.println("Message : " + s);

				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				System.out.println("클라이언트로 보낼 메세지 입력");

				s = ssc.next();

				bw.write(s);
				bw.write("\r\n");
				bw.flush();
				if (s.equals("end")) {

					System.out.println("종료합니다");
					break;
				}

			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				br.close();
				ir.close();
				is.close();
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
