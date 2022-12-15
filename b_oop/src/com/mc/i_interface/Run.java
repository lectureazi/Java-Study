package com.mc.i_interface;

import java.util.Iterator;

public class Run {

	//다형성 : 객체를 여러 타입으로 다루는 것
	//			상속을 통해서 부모클래스의 타입을 물려받기 때문
	//			상속 : 메서드, 속성, 타입
	public static void main(String[] args) {
		
		//제조사, 상품명, 가격, cpu, ram, 일체여부
		Desktop desktop = new Desktop("삼성","울트라",2000000,"intel", 16, true);

		//제조사, 상품명, 가격, cpu, ram, 통신사
		SmartPhone smartPhone = new SmartPhone("사과", "아이폰", 13000000, "긱벤치", 8, "SKT");

		//제조사, 상품명, 가격, inch(크기)
		TV tv = new TV("LG", "LG티비", 3000000, 52);
		
		Product[] products = {desktop, smartPhone, tv};
		
		for (int i = 0; i < products.length; i++) {
			System.out.println(products[i]);
		}
		
		System.out.println(desktop);
		System.out.println(smartPhone);	//레퍼런스를 println에 넣으면 자동으로 toString을 호출
		System.out.println(tv);	

	}
}
