package com.mc.coffeemanager.presentation;

import java.util.Scanner;

import com.mc.coffeemanager.service.Account;
import com.mc.coffeemanager.service.Coffee;
import com.mc.coffeemanager.service.Order;
import com.mc.coffeemanager.service.Payment;
import com.mc.coffeemanager.service.Sales;


public class Menu {
	
	Account account = Account.getInstance();
	Sales sales;
	Coffee[] drinks;
	
	Scanner sc = new Scanner(System.in);

	public Menu(Sales sales, Coffee[] drinks) {
		super();
		this.sales = sales;
		this.drinks = drinks;
	}
	
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("\n=========Menu=========");
			System.out.println("판매등록(1)");
			System.out.println("현황(2)");
			System.out.println("종료(3)");
			System.out.print("입력 : ");
			
			int inputMenu = sc.nextInt();
			
			switch (inputMenu) {
			case 1:
				coffeeMenu();
				break;
			case 2:
				statistics();
				break;
			case 3:
				System.out.println(" * 종료합니다.");
				return;
			default:
				System.out.println(" * 잘못된 번호를 입력하셨습니다.");
				break;
			}
		}
	}

	private void statistics() {
		System.out.println("\n=========statistics========= ");
		for (int i = 0; i < drinks.length; i++) {
			System.out.println(drinks[i].getName() + "| 재고 : " + drinks[i].getStock()
												+ "| 판매량 : " + drinks[i].getTotalSalesCnt());
		}
		
		System.out.println("잔고 : " + account.getBalance() + " | 매출 : " + account.getSalesVolumn() 
				+ " | 지출 : " + account.getExpences());
		
	}

	private void coffeeMenu() {
		//음료 메뉴판
		System.out.println("\n=========List========= ");
		for (int i = 0; i < drinks.length; i++) {
			System.out.println(drinks[i].getName() + "(" + i + ")");
		}
		
		System.out.print("\n * 판매한 커피코드 : ");
		int inputCode = sc.nextInt();
		System.out.print(" * 판매량 : ");
		int orderCnt = sc.nextInt();
		
		if(inputCode < 0 || inputCode >= drinks.length) {
			System.out.println("정확한 상품번호를 선택해 주세요.");
			return;
		}
		
		registerOrder(inputCode, orderCnt);
	}

	private void registerOrder(int inputCode, int orderCnt) {
		
		Order order = Order.createOrder(drinks[inputCode], orderCnt);
		
		if(order.getStatus().isFail()) {
			System.out.println(order.getStatus().desc());
			return;
		}
		
		Payment payment = sales.takeOrder(order);
		orderResult(payment);
		
	}

	private void orderResult(Payment payment) {
		
		Order order = payment.getOrder();
		System.out.println("\n 제품명 : " + order.getCoffee().getName());
		System.out.println(" 판매가 : " +  order.getCoffee().getPrice());
		System.out.println(" 판매수량 : " + order.getOrderCnt());
		System.out.println(" 결제금액 : " + payment.getPayPrice());
		System.out.println(" 남은 재고 : " + order.getCoffee().getStock() );
		System.out.println(order);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
