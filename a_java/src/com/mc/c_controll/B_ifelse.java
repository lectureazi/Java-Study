package com.mc.c_controll;

import java.util.Scanner;

public class B_ifelse {
	
	//자바의 변수의 수명 (scope)
	//자바 변수의 스코프 :  블록단위스코프
	
	// 양자택일 조건문
	// [표현식]
	// if(조건식){실행코드}else{실행코드}
	public static void main(String[] args) {
		
		testIfElse();
		
		// 사용자가 입력한 숫자가 
		// 0보다 크면 '양수'를  
		// 0보다 작으면 '음수'를  
		// 0이라면 0을 출력 하시오
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 하나 입력하세요");
		int input = sc.nextInt();
		
		String comment = "";
		
		if(input > 0) {
			comment = "양수";
		}else {
			if(input < 0) {
				comment = "음수";
			}else {
				comment = "0";
			}
		}
		
		System.out.println(comment);
		
		
	}

	private static void testIfElse() {
		// 사용자로부터 이름을 입력받아, 만약 이름이 본인의 이름이면
		// [안녕하세요] 를 출력하고 아니면 [당신 누구야] 를 출력합시다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String name = sc.nextLine();
		String comment = "";
		
		if(name.equals("하명도")) {
			comment = "안녕하세요";
		}else {
			comment = "당신 누구야?";
		}
		
		//String comment = name.equals("하명도")?"안녕하세요":"당신 누구야?";
		System.out.println(comment);
	}
	
	
	
}
