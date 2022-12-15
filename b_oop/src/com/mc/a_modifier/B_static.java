package com.mc.a_modifier;

public class B_static {
	
	// static : [클래스의] 의미를 지니는 제한자
	
	// 변수 앞에 static을 붙이면 해당 변수는 JVM의 static 영역에 올라가게 된다.
	// static 영역에 올라간 데이터는 클래스로더가 클래스를 메모리에 올릴 때 올라가게 되며
	// 프로그램이 종료될 때 까지 메모리에서 내려오지 않는다.
	
	// static변수나 메서드는 Type.이름 형태로 사용할 수 있다.
	
	// 필드변수
	// 		- 인스턴스 변수 : 필드변수 중에 일반적인 변수, 클래스를 인스턴스화 할 때 메모리에 올라가고, 
	//						인스턴스가 메모리에서 삭제될 때 함께 삭제
	//						인스턴스 변수의 사용법 : 레퍼런스변수명.이름
					
	//		- 클래스 변수   : 필드변수 중에 static 제한자를 사용한 변수, 클래스로더가 클래스를 메모리에 올릴 때 올라가고,
	//						프로그램이 종료될 때 까지 삭제되지 않는다.
	//						클래스 변수의 사용법   : 타입(클래스의 이름).이름
	
	
	
	//필드변수
	//인스턴스 변수
	String nonStatic = "static 아님";
	
	//클래스변수
	static String staticVal = "static임";
	
	//일반 메서드
	public void testMethod() {
		System.out.println("일반 메서드 입니다.");
	}
	
	//static 메서드
	public static void testStatic() {
		System.out.println("static 메서드 입니다.");
	}
	
	
	
	


}
