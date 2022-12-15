package com.mc.first;

import java.util.Scanner;

public class B_키보드입력 {
	
	// Scanner :표준입력장치(키보드)를 통해 외부로부터 데이터를 입력받는 것을 도와주는 클래스
	// 다른 패키지의 클래스를 사용하려면, 참조형 변수를 선언할 때 클래스의 full name(패키지명 + 클래스명) 을 써야한다.
	// import 문을 선언하면 클래스명 만으로 참조형 변수를 선언할 수 있다.

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.println("나의 이름은 " + name + "입니다.");
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.println("나의 나이는 " + age + "살 입니다.");
		

	}
}
