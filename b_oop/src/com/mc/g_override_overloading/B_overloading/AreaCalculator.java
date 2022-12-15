package com.mc.g_override_overloading.B_overloading;

public class AreaCalculator {

	// Overload : 과적하다, 넘치게 싣다.
	//			 하나의 이름에 메서드가 여러 개 존재
	//			 Overload는 매개변수의 개수나 타입이 다른 같은 이름의 메서드를 여러개 만드는 것을 의미
	//			 Overload를 할 때는 두 메서드의 의미상의 기능이 동일 해야한다.
	public static double calArea(Rectangle r) {
		return r.getHeight() * r.getWidth();
	}
	
	public static double calArea(Circle c) {
		return Math.PI * c.getRadius() * c.getRadius();
	}

}
