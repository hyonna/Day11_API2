package com.io.file.rw;

import java.util.ArrayList;

public class MemberView {
	
	
	public void view(String str) {
		
		System.out.println(str);
		
	}
	
	
	public void view(Member s) {
		
		
		System.out.println("그룹명 : " + s.getGroup() + "\t");
		System.out.println("이름 : " + s.getName() + "\t");
		System.out.println("나이 : " + s.getAge() + "\t");
		System.out.println("담당 : " + s.getPosition() + "\t");
		System.out.println("소속사 : " + s.getAgency() + "\t");
		System.out.println();
		
		
	}
	
	
	public void view(ArrayList<Member> ar) {
		
		for (Member s : ar) {

			//그룹명 , 이름, 나이, 담당, 소속사
			System.out.println("그룹명 : " + s.getGroup() + "\t");
			System.out.println("이름 : " + s.getName() + "\t");
			System.out.println("나이 : " + s.getAge() + "\t");
			System.out.println("담당 : " + s.getPosition() + "\t");
			System.out.println("소속사 : " + s.getAgency() + "\t");
			System.out.println();

		}

		
		
	}
	
	

}
