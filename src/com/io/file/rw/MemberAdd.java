package com.io.file.rw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberAdd {
	
	public void backup(ArrayList<Member> ar) {
		
		//파일의 저장 경로 : 원래 파일에다가 덮어씌우기
		
		File file = new File("c:\\test", "readTest.txt");
		FileWriter fw = null;
		
		try {

			fw = new FileWriter(file, false);
			fw.write("start");
			
			for(Member m : ar) {
				
				StringBuffer sb = new StringBuffer();
				sb.append(m.getGroup());
				sb.append("-");
				sb.append(m.getName());
				sb.append("-");
				sb.append(m.getAge());
				sb.append("-");
				sb.append(m.getPosition());
				sb.append("-");
				sb.append(m.getAgency());
				sb.append("\r\n");
				
				fw.write(sb.toString());
				
				fw.flush();
			}
			
			

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

	public Member addMember(Scanner sc, ArrayList<Member> ar) {

		Member member = new Member();

		System.out.println("그룹명을 입력하세요");
		member.setGroup(sc.next());
		System.out.println("이름을 입력하세요");
		member.setName(sc.next());
		System.out.println("나이를 입력하세요");
		member.setAge(sc.nextInt());
		System.out.println("담당을 입력하세요");
		member.setPosition(sc.next());
		System.out.println("소속사를 입력하세요");
		member.setAgency(sc.next());

		ar.add(member);

		return member;
	}

}
