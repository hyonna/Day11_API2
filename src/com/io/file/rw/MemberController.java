package com.io.file.rw;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {

	private Scanner sc;
	private MemberInfo mi;
	private MemberView mv;
	private MemberAdd ma;

	public MemberController() {

		sc = new Scanner(System.in);
		mi = new MemberInfo();
		mv = new MemberView();
		ma = new MemberAdd();

	}

	public void start() {

//		MemberInfo mi = new MemberInfo();
//		ArrayList<Member> ar = mi.getMembers();
//		
//		//모든 이름을 출력
//		MemberView mv = new MemberView();
//		mv.view(ar);
//		
//		System.out.println("종료합니다");

		// 1. 멤버 정보 가져오기
		// 2. 멤버 정보 출력하기
		// 3. 종료

		ArrayList<Member> ar = null;
		boolean check = true;
		while (check) {

			System.out.println("1. 멤버 정보 가져오기");
			System.out.println("2. 멤버 정보 출력하기");
			System.out.println("3. 멤버 정보 검색하기");
			System.out.println("4. 그룹 정보 검색하기");
			System.out.println("5. 멤버 추가 하기");
			System.out.println("6. 백업");
			System.out.println("7. 종료");
			int select = sc.nextInt();

			switch (select) {

			case 1:

				ar = mi.getMembers();

				break;

			case 2:

				mv.view(ar);
				break;

			case 3:

				Member m = mi.searchMember(sc, ar);

				if (m != null) {

					mv.view(m);

				} else {

					mv.view("입력한 사람이 없습니다");
				}

				break;

			case 4:

				ArrayList<Member> search = mi.searchGroup(sc, ar);

				if (search.size() > 0) {

					mv.view(search);

				} else {

					mv.view("입력한 정보가 없습니다");
				}

				break;
				
			case 5:
				
				
				Member m1 = ma.addMember(sc, ar);
				ar.add(m1);
				
				
				break;
				
			case 6:
				
				ma.backup(ar);
				break;
				

			default:

				System.out.println("종료");
				check = !check;
				sc.close();
			}

		}

	}

}
