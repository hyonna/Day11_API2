package com.io.file.rw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {

	public static void main(String[] args) {

		File file = new File("c:\\test", "WriteTest.txt");
		FileWriter fw = null;

		try {

			fw = new FileWriter(file, true);
			
			
			fw.write("Fiveth Write \r\n");
			
			
			fw.flush();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				fw.close();

			} catch (IOException e) {

				e.printStackTrace();

			}
		}

		System.out.println("파일 작성 완료");
		
	}

}
