package com.mc.a_variable;

public class B_상수 {

	public static void main(String[] args) {
		// 변수 : 값을 수정할 수 있다.
		// 상수 : 초기화 이후 값을 수정할 수 없다.
		
		// 상수를 만드는 방법
		// 변수 앞에 final 예약어를 사용해 상수로 만들 수 있다.
		// 예약어 : 자바에서 특수한 용도로 미리 약속해둔 키워드

		// 변수, 메서드 표기법 : 변수와 메서드는 camelCase 표기법을 따른다.
		//					  camelCase : 이름을 지을 때 여러 단어를 결합해서 지을 경우 단어의 구분을 대문자로 구분하는 방식
		//						ex) coffeePrice
		
		// 클래스 표기법 : camelCase를 따르되, 제일 첫 글자가 대문자이다.
		
		// 상수 표기법 : uppercase snake 표기법을 따른다.
		//				 snake표기법 : 이름을 지을 때 여러 단어를 결합해서 지을 경우, 단어의 구분을 _ 로 하는 방식
		//				    ex) food_price
		//				 uppercase snake : FOOD_PRICE
		
		
		int age = 10;
		final int BOOK_CNT = 20;
		
		age = 50;
		
		// 상수는 수정이 불가능하다.
		//BOOK_CNT = 10;
		
		System.out.println(BOOK_CNT);
		
		

	}

}
