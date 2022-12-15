package com.mc.c_init;

public class Initialization {
	
	// 필드변수의 초기화 순서
	// 인스턴스 변수 : jvm의 기본 값  => 필드변수에 직접 대입한 값 => 초기화 블록 => 생성자
	// 클래스 변수   : jvm의 기본 값  => 필드변수에 직접 대입한 값 => static 초기화블록
	
	private String name = "하명도";
	private static int classCode = 777;
	
	//초기화 블록
	//클래스가 인스턴스화 되는 순간에 한번만 호출되어, 인스턴스 변수의 값을 초기화 하는 용도
	//생성자보다 먼저 호출 된다.
	{
		System.out.println("필드변수에 직접 대입한 값 : " + name);
		name = "HMD";
		System.out.println("초기화블록이 호출된 이후의 값 : " + name);
	}
	
	//static 초기화 블록
	//클래스로더가 클래스를 메모리에 올리는 시점 => 클래스가 최초로 사용되는 시점에 동작
	static {
		System.out.println("스테틱 변수에 직접 대입한 값 : " + classCode);
		classCode = 999;
		System.out.println("스테틱 초기화 블록이 호출된 이후의 값 : " + classCode);
	}
	
	public Initialization() {
		name = "MDH";
		System.out.println("생성자 호출 이후 값 : " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getClassCode() {
		return classCode;
	}

	public static void setClassCode(int classCode) {
		Initialization.classCode = classCode;
	}
	
	
	
	
	
	
	
	
	
	

}
