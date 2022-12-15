package com.mc.c_controll;

import java.util.Scanner;

public class E_while {
	
	// [표현식]
	// while(조건식){실행코드}
	// 조건식이 참이면 실행코드를 반복
	// 조건식이 거짓이면 반복을 종료
	public static void main(String[] args) {
		
		//무한반복문
//		while(true) {
//			System.out.println("멈추지 않아! 중요한 건 꺾이지 않는 마음");
//		}
				
		//studyWhile();
		
		//사용자로부터 비밀번호를 입력받아서
		//비밀번호가 일치하면 "로그인 되었습니다."를 출력하고 반복문을 종료
		//비밀번호가 일치하지 않으면 "비밀번호가 틀렸습니다"를 출력하고 다시 비밀번호를
		//입력받을 수 있도록 한다.
		// * 비밀번호 :  123abc
		
		Scanner sc = new Scanner(System.in);
		
		//저장된 비밀번호
		String password = "123abc";
		
		boolean isAnony = true;
		
		while(isAnony) {
			System.out.println("비밀번호를 입력하세요");
			String input = sc.nextLine();
			
			if(input.equals(password)) {
				System.out.println("로그인 되었습니다.");
				isAnony = false;
			}else {
				System.out.println("비밀번호를 다시 입력하세요");
			}
		}
		
		//extracted();
	}

	private static void extracted() {
		//5번 반복하는 while문
		int i = 0;
		
		while(i < 5) {
			System.out.println("멈추지 않아! 중요한 건 꺾이지 않는 마음");
			i++;		
		}
	}


	

}
