package com.mc.b_operator;

public class E_논리연산자 {
	
	
	//논리연산자 : &&, ||
	// && : 두 항이 모두 true일 때 true, ~면서, 그리고, and
	// || : 두 항이 모두 false 일 때 false, 또는, ~거나, or
	//		두 항 중 한 항이 true이면 true이다.
	public static void main(String[] args) {
		
		System.out.println(2 >= 2 || 2 > 3); // true || false  == true
		System.out.println(2 > 1 || 3 > 2);  // true || true == true
		System.out.println(3 < 2 || 2 > 3);  // false || false == false
		System.out.println(2 < 2 || 2 < 3);  // false || true == true
		
		System.out.println(2 >= 2 && 2 > 3); // true && false  == 
		System.out.println(2 > 1 && 3 > 2);  // true && true == 
		System.out.println(3 < 2 && 2 > 3);  // false && false == 
		System.out.println(2 < 2 && 2 < 3);  // false && true == 
		
		
		boolean a = true;
		boolean b = false;
		boolean c = false;
		boolean d = false;
		
		//아래 논리연산의 출력값을 예상해보세요
		System.out.println((a || b) && c || d);
		
		// 왼쪽부터 연산을 수행해보면
		// true || false  == true
		// true && false == false
		// false || false == false
		
		// false && false == false
		// true || false == true
		// true || false == true

		// 따라서 연산결과는 true
		// () 를 사용해 연산 우선순위를 바꿀 수 있다.

		
		
		
		
	}

}
