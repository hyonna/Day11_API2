package com.io.file.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberInfo {

	private ArrayList<Member> searchCompany(Scanner sc, ArrayList<Member> ar) {

		ArrayList<Member> search = new ArrayList<Member>();
		System.out.println("소속사를 입력하세요");
		String name = sc.next();

		for (Member m : ar) {

			if (name.equals(m.getAgency())) {

				search.add(m);
			}
		}

		return search;

	}

	private ArrayList<Member> searchTeam(Scanner sc, ArrayList<Member> ar) {

		ArrayList<Member> search = new ArrayList<Member>();
		System.out.println("그룹명을 입력하세요");
		String name = sc.next();

		for (Member m : ar) {

			if (name.equals(m.getGroup())) {

				search.add(m);

			}

		}

		return search;
	}

	public ArrayList<Member> searchGroup(Scanner sc, ArrayList<Member> ar) {

		// 메서드명 searchGroup, (매개변수 -> Scanner, ArrayList)
		// 1. 그룹명, 2.소속사

		ArrayList<Member> search = null;

		System.out.println("1. 그룹명");
		System.out.println("2. 소속사");
		int select = sc.nextInt();

		if (select == 1) {

			search = this.searchTeam(sc, ar);

		} else {

			search = this.searchCompany(sc, ar);

		}

		return search;

	}

	public Member searchMember(Scanner sc, ArrayList<Member> ar) {

		// 메서드명 searchMember, (매개변수 -> Scanner, ArrayList)
		// 이름을 입력해서 멤버찾기

		System.out.println("검색할 이름을 입력하세요");
		String name = sc.next();

		Member member = null;

		for (Member m : ar) {

			if (name.equals(m.getName())) {

				member = m;
				break;

			}

		}

		return member;

	}

	// 메서드명 getMembers

	public ArrayList<Member> getMembers() {

		FileReader fr = null;
		BufferedReader br = null;
		File file = new File("c:\\test", "readTest.txt");
		ArrayList<Member> ar = new ArrayList<Member>();

		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			// \n 개행문자

			String str = null;
			br.readLine();

			while (true) {

				str = br.readLine();

				if (str == null) {

					break;
				}

				String[] names = str.split("-");

				Member m = new Member();

				m.setGroup(names[0]);
				m.setName(names[1]);
				m.setAge(Integer.parseInt(names[2]));
				m.setPosition(names[3]);
				m.setAgency(names[4]);

				ar.add(m);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				br.close();
				fr.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		return ar;

	}

}
