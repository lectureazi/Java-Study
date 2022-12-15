package com.mc.d_encapsulation.after;

public class Run {

	public static void main(String[] args) {
		
		//제조사, 상품명, 가격, cpu, ram, 일체여부
		Desktop desktop = new Desktop("삼성","울트라",2000000,"intel", 16, true);

		//제조사, 상품명, 가격, cpu, ram, 통신사
		SmartPhone smartPhone = new SmartPhone("사과", "아이폰", 13000000, "긱벤치", 8, "SKT");

		//제조사, 상품명, 가격, inch(크기)
		TV tv = new TV("LG", "LG티비", 3000000, 52);
		
		
		System.out.println(desktop);
		System.out.println(smartPhone);	//레퍼런스를 println에 넣으면 자동으로 toString을 호출
		System.out.println(tv);	

	}
}
