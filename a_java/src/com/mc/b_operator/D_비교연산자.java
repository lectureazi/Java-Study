package com.mc.b_operator;

public class D_비교연산자 {
	
	// 비교연산자 :  <, >, <=, >=, ==, !=
	// 연산의 결과가 논리값
	
	public static void main(String[] args) {
		int x = 20, y = 10;
		
		//대소비교
		System.out.println(x > y);
		System.out.println(x >= y);
		System.out.println(x < y);
		System.out.println(x <= y);
		
		//primitive 타입은 ==, != 를 사용하지만
		//참조타입은 equal() 메서드를 사용함
		
		//등위비교
		System.out.println(x == y);
		System.out.println(x != y);
		
		String name = "홍길동";
		String nameB = new String("홍길동");
		System.out.println(name == nameB);
		System.out.println(name.equals(nameB));
		
		
		
		
		
	}

}
