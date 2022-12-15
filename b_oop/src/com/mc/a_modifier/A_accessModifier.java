package com.mc.a_modifier;

public class A_accessModifier {
	
	//제한자(modifier)
	//접근제한자 : public, protected, private, default(생략)
	//그 외 제한자 : static, final, abstract, void, synchronized
	
	//접근제한자 : 변수나 메서드에 접근할 수 있는 범위를 제한하는 제한자
	
	//public : 다른 패키지 내의 클래스에서도 호출할 수 있다.
	public static void publicMethod() {
		System.out.println("접근제한자가 public");
	}

	// default : 같은 패키지 내의 클래스에서만 호출할 수 있다.
	// 생략하면 접근제한자가 default이다.
	static void defaultMethod() {
		System.out.println("접근제한자가 default");
	}
	
	// protected : 같은 패키지 내의 클래스나, 상속관계인 클래스에서 호출할 수 있다.
	protected static void protectedMethod() {
		System.out.println("접근제한자가 protected");
	}
	
	// private : 같은 클래스 안에서만 호출이 가능
	private static void privateMethod() {
		System.out.println("접근제한자가 private인 메서드 입니다.");
	}
	
	
	
	
	
}
