package com.mc.a_modifier;

public class StaticTest {

	public static void main(String[] args) {
		
		//static
		System.out.println(B_static.staticVal);
		
		
		// heap영역에 인스턴스변수의 공간을 확보하고 초기화
		B_static nonStatic = new B_static(); 
		B_static ns2 = new B_static();
			
		
		//heap영역에 올라간 객체주소를 저장하고 있는 레퍼런스를 통해 인스턴스 변수 호출
		System.out.println("nonStatic: " +  nonStatic.nonStatic); 
		System.out.println("ns2 : " + ns2.nonStatic);
		
		nonStatic.nonStatic = "not static";
		
		System.out.println("nonStatic: " +nonStatic.nonStatic); 
		System.out.println("ns2 : " +ns2.nonStatic);
		
		
		System.out.println(">>>>>>> nonStatic : " + nonStatic.staticVal);
		nonStatic.staticVal = "yes static";
		System.out.println(">>>>>>> nonStatic : " + nonStatic.staticVal);
		
		System.out.println(ns2.staticVal);
		
		
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		B_static.testStatic();
		nonStatic.testMethod();

	}

}
