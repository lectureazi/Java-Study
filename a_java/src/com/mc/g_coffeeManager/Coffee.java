package com.mc.g_coffeeManager;

public class Coffee {
	
	// 클래스
	// 속성 + 기능
	
	// 구조체
	// 다른 타입의 데이터들을 하나의 변수로 다루기 위한 자료구조
	
	// 함수
	
	String name;
	int price;
	int cost;
	int stock;
	int safetyStock;
	int salesCnt;
	
	//매개변수가 하나도 없는 기본 생성자는, 명시적으로 작성하지 않을 경우
	//컴퓨터가 자동으로 생성을 해준다.
	public Coffee() {
		
	}
	
	public Coffee(String name, int price, int cost, int stock, int safetyStock, int salesCnt) {
		//this: heap영역에 생성된 인스턴스의 메모리 주소를 저장하고 있는 참조형 변수
		this.name = name;
		this.price = price;
		this.cost = cost;
		this.stock = stock;
		this.safetyStock = safetyStock;
		this.salesCnt = salesCnt;
	}
	
	
	
	
	
	
	

}
