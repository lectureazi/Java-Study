package com.mc.b_operator;

public class H_복합대입연산자 {
	
	//대입연산자와 다른 연산자를 함께 사용하면 복합대입연산자.
	public static void main(String[] args) {
		
		int num = 12;
		num = num + 12;
		System.out.println(num);
		
		num += 12;
		System.out.println(num);
		
		num -= 12;
		System.out.println(num);
		
		num *= 12;
		System.out.println(num);
		
		num /= 12;
		System.out.println(num);
		
		num %= 11;
		System.out.println(num);
		
		q1();
	}

	private static void q1() {
		// 대입연산자만을 활용해 a와 b의 값을 바꿔주세요.
		// a = "2번"; ==> 같은 리터럴 직접 대입은 안됩니다.
		String a = "1번";
		String b = "2번";
		String c = a;
		a = b;
		b = c;
		
		System.out.println(a);
		System.out.println(b);
	}
	
	
	

}
