package com.mc.g_override_overloading.B_overloading;

public class run {

	public static void main(String[] args) {
		
		//반지름이 5인 원의 넓이를 구하시오.
		Circle circle = new Circle();
		circle.setRadius(5);
		
		System.out.println(circle.getRadius());
		
		double area = AreaCalculator.calArea(circle);
		System.out.println(area);
		

		//너비가 4 높이가 7인 직각사각형의 넓이를 구하시오.
		Rectangle rect = new Rectangle();
		
		rect.setHeight(7);
		rect.setWidth(4);
		
		double rectArea = AreaCalculator.calArea(rect);
		System.out.println(rectArea);
		
	}
}
