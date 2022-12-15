package com.mc.h_abstract;

public class run {

	public static void main(String[] args) {
		//추상 클래스는 인스턴스화 할 수 없다.
		//Figure f = new Figure();
		//System.out.println(f.calArea());
		
		Figure[] figures = {new Circle(5), new Rectangle(4, 7)};
		
		for (Figure figure : figures) {
			System.out.println(figure.calArea());
		}
		
	}
}
