package com.mc.g_override_overloading.A_override;

public class Figure {
	
	private String privateTest = "privat은 상속이 안됩니다.";
	public int area = 0;
	
	public double calArea() {
		return 0.0;
	}
	
	private void testExtends() {
		System.out.println("private은 상속이 안됩니다.");
	}
	
	public static void testStaticExtends() {
		System.out.println("static은 상속이 안됩니다.");
	}

}
