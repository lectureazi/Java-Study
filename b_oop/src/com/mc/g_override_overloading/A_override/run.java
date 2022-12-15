package com.mc.g_override_overloading.A_override;

public class run {

	public static void main(String[] args) {
		
		// 원과 사각형의 넓이를 구하는 코드를 작성하시되, 다형성을 이용하여 코드를 줄여보세요.
		
		Figure[] figures = {new Circle(5), new Rectangle(4, 7)};
		
		figures[0].testStaticExtends();
		Circle c = (Circle) figures[0];
		c.testStaticExtends();
		
		
		for (Figure figure : figures) {
			//강제형변환
			//선조타입으로 형변환 할 때는(UpCasting) : 자동형변환
			//		자식타입에는 자식타입이 상속받은 선조타입에 대한 정보가 있다. 그래서 자동캐스팅 가능
			
			//선조타입을 후손타입으로 형변환 할때는 (DownCasting) : 명시적형변환
			//		선조타입은 자신을 상속받고 있는 클래스가 무엇인지에 대한 정보가 없다
			
			//Figure f = new Figure();
			//Circle c2 = (Circle) f[0];
			
			//가능 1 / 불가능 2
			System.out.println(figure.calArea());
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		

	}
}
