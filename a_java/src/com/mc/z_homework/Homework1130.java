package com.mc.z_homework;

import java.util.Scanner;

public class Homework1130 {

	public static void main(String[] args) {
		q8();
	}

	// 사용자로부터 줄 수와 칸수를 입력받아서
	// 사각형을 별로 그리는 이중반복문 작성하시오

	// 출력예시
	// 줄 수 : 3
	// 칸 수 : 4
	// ****
	// ****
	// ****
	private static void q1() {

		Scanner sc = new Scanner(System.in);
		System.out.println("줄 수를 입력하세요.");
		int row = sc.nextInt();
		System.out.println("칸 수를 입력하세요.");
		int column = sc.nextInt();

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < column; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}

	// 사용자로부터 정수를 하나 입력받아
	// 사각형을 별로 그리는 데, 대각선에는 숫자를 출력하시오
	// 숫자는 1~사용자가 입력한 숫자까지.

	// 출력 예시
	// 숫자 : 4
	// 1***
	// *2**
	// **3*
	// ***4
	private static void q2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요.");
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {

			for (int j = 0; j < num; j++) {

				if (i != j) {
					System.out.print("*");
				} else {
					System.out.print(i + 1);

				}
			}

			System.out.println();
		}
	}

	// 사용자로부터 정수를 하나 입력받아
	// 정수만큼의 높이를 가지는 직각삼각형을 * 을 사용해 그리세요
	// 이 때 빗변은 해당 행의값을 출력합니다.
	// 출력예시 : 숫자 : 5
	// 1
	// *2
	// **3
	// ***4
	// ****5
	private static void q3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요.");
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {

			for (int j = 0; j < num; j++) {
				if (i != j) {
					System.out.print("*");
				} else {
					System.out.print(i + 1);
					break;
				}
			}

			System.out.println();
		}
	}

	// 사용자로부터 다운로드 받을 프로그램 갯수를 입력받아
	// 다운로드 진행창을 출력하시오

	// 사용자로부터 다운로드 받을 프로그램의 개수 입력받는다.
	// [출력양식]
	// n번째 프로그램 다운로드 받습니다.
	// 0% 진행중...
	// 20% 진행중...
	// 40% 진행중...
	// 60% 진행중...
	// 80% 진행중...
	// 100% 진행중...
	// n번째 프로그램 다운로드 완료되었습니다.
	// -------------------------------
	// 모든 프로그램 다운로드 완료
	private static void q4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("프로그램 개수 : ");
		int cnt = sc.nextInt();

		for (int i = 0; i < cnt; i++) {

			System.out.println(i + 1 + "번째 프로그램 다운로드 받습니다.");

			for (int j = 0; j < 6; j++) {
				System.out.println(j * 20 + "% 진행중...");
			}

			System.out.println(i + 1 + "번째 프로그램 다운로드 완료되었습니다.");
			System.out.println("--------------------------------------------");
		}

		System.out.println();
		System.out.println("모든 프로그램 다운로드 완료");
	}

	// 사용자로부터 숫자와 방향(+,-) 를 입력받아
	// 사용자가 입력한 방향에 따라 삼각형 밑변의 위치를 다르게 출력하시오.
	//
	// [출력예시]
	// 숫자 : 4
	// 방향(+ 또는 -) : -
	// ****
	// ***
	// **
	// *

	// 숫자 : 5
	// 방향(+ 또는 -) : +
	// *
	// **
	// ***
	// ****
	// *****
	public static void q5() {
		// 사용자로 부터 정수를 하나 입력받는다.
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int cnt = sc.nextInt();
		System.out.print("방향(+ 또는 -) : ");
		String dir = sc.next();

		switch (dir) {
		case "+":
			for (int i = 1; i < cnt + 1; i++) {
				for (int j = 0; j < cnt; j++) {
					System.out.print("*");
					if (j == cnt - i) break;
				}
				System.out.println();
			}
			break;
		case "-":
			for (int i = 0; i < cnt; i++) {
				for (int j = 0; j < cnt; j++) {
					System.out.print("*");
					if (i == j)
						break;
				}
				System.out.println();
			}

			break;

		default:
			System.out.println("제대로 입력하시죠!");
			break;
		}
	}

	//	숫자 : 5
	//	방향(+ 또는 -) : +
	//	    *
	//	   ***
	//	  *****
	//	 *******
	//	*********
	
	//	숫자 : 5
	//	방향(+ 또는 -) : -
	//	*********
	//	 *******
	//	  *****
	//	   ***
	//	    *
	public static void q6() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하거라:");
		int cnt = sc.nextInt();
		
		System.out.println("방향(+ , -) : ");
		String dir = sc.next();
		
		switch (dir) {
		case "+":
			int n = cnt - 1;
			
			for (int i = 0; i < cnt; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(" ");
				}
				
				for (int j = 0; j < 2*i+1; j++) {
					System.out.print("*");
				}
				n--;
				System.out.println();
			}
			
			break;
		case "-":
			int n2 = cnt;
			
			for (int i = 0; i < cnt; i++) {
				
				for (int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				
				for (int j = 0; j < 2*n2-1; j++) {
					System.out.print("*");
				}
				
				n2--;
				System.out.println();
			}
			
			break;
		default:
			System.out.println("기호가 이상합니다.");
			break;
		}
	}


	//	사용자로부터 숫자를 입력 받아 해당 숫자를 한 변의 길이로 가지는 마름모를 출력하시오.
	
	//	출력예시
	//	숫자 : 5
	//	    *
	//	   ***
	//	  *****
	//	 *******
	//	*********
	//	 *******
	//	  *****
	//	   ***
	//	    *
	public static void q7() {
		
		Scanner sc =  new Scanner(System.in);
		System.out.println("숫자를 하나 입력하세요.");
		int cnt =  sc.nextInt();
		
		int n = cnt - 1;
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < 2*i+1; j++) {
				System.out.print("*");
			}
			n--;
			System.out.println();
		}
		
		int n2 = cnt-1;
		
		for (int i = 0; i < cnt; i++) {
			
			for (int j = 0; j < i+1; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < 2*n2-1; j++) {
				System.out.print("*");
			}
			
			n2--;
			System.out.println();
		}
		
	}
	
	//2선승 가위바위보
	//2선승이 결정될 때 까지 사용자로부터 반복해서 패를 입력받고 가위바위보 결과를 판정하는 코드가 실행
	public static void q8() {
		
		Scanner sc = new Scanner(System.in);
		int win = 0;
		int lose = 0;
		int semi = 0;
		
		while(win < 2 && lose < 2) {
			
			System.out.print("1P :" );
			String p1 = sc.next();
			System.out.print("2P : ");
			String p2 = sc.next();
			
			// p1, p2 : 전달인자, calGameResult에 사용자로 부터 입력받은 패를 전달
			String msg = calGameResult(p1, p2);
			
			if(msg.equals("이겼습니다.")) win++;
			if(msg.equals("비겼습니다.")) semi++;
			if(msg.equals("졌습니다.")) lose++;
			
			System.out.println(msg);
		}
		
		System.out.println(win + "승 " + semi  + "무 " + lose + "패 하였습니다.");
		
	}
	
	//매개변수 : 호출부에서 전달하는 값인 전달인자를 저장하기 위한 변수
	//반환형(return type): 메서드의 실행이 끝났을 때 호출부로 반환할 값의 타입
	public static String calGameResult(String p1, String p2) {
		String msg = "";
		
		if(p1.equals(p2)) {
			msg = "비겼습니다.";
			return msg;
		}
		
		if(p1.equals("가위") && p2.equals("보")) {
			msg = "이겼습니다.";
		}else if (p1.equals("바위") && p2.equals("가위")) {
			msg = "이겼습니다.";
		}else if(p1.equals("보") && p2.equals("바위")) {
			msg = "이겼습니다.";
		}else {
			msg = "졌습니다.";
		}
		
		return msg;
	}
	
	
	
	
	
	
	
	
	
	
	
}
