package com.mc.f_array;

import java.util.Scanner;

public class I_CoffeeManager {

	public static void main(String[] args) {
		
		int balance = 100000;//잔고 100000
		int salesPrice = 0;//매출
		int expences = 0;//지출
		
		String[] names = {"아메리카노", "모카", "라떼"};
		int[] prices = {3000, 4000, 5000};
		int[] costs = {2000, 3000, 4000};
		int[] stocks = {10, 10, 10};
		int[] safetyStocks = {3, 3, 3};
		int[] salesCnts = {0, 0, 0};
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n=========Menu=========");
			System.out.println("판매등록(1)");
			System.out.println("현황(2)");
			System.out.println("종료(3)");
			System.out.print("입력 : ");
			
			int inputMenu = sc.nextInt();
			
			if(inputMenu == 1) {
				//음료 메뉴판
				for (int i = 0; i < names.length; i++) {
					System.out.println(names[i] + "(" + i + ")");
				}
				
				System.out.print("\n * 판매한 커피코드 : ");
				int inputCode = sc.nextInt();
				System.out.print(" * 판매량 : ");
				int orderCnt = sc.nextInt();
				
				if(inputCode < 0 || inputCode >= names.length) {
					System.out.println("정확한 상품번호를 선택해 주세요.");
					continue;
				}
	
				if(orderCnt > stocks[inputCode]) {
					//주문량이 재고보다 많으면 주문을 취소한다.
					System.out.println("재고가 부족해 주문을 취소합니다.");
					continue;
				}
				
				//주문량이 재고보다 적거나 같으면 판매 수량만큼 재고를 차감하고, 
				//잔고에 판매 금액을 반영한다.
				stocks[inputCode] -= orderCnt;
				balance += prices[inputCode] * orderCnt;			
				salesPrice += prices[inputCode] * orderCnt;
				salesCnts[inputCode] += orderCnt;
				
				//커피 재고가 안전재고 미만이 되면 안전재고의 두 배 만큼 매입한다.
				if(stocks[inputCode] < safetyStocks[inputCode]) {
					
					if(balance > safetyStocks[inputCode] * 2 * costs[inputCode]) {
						stocks[inputCode] += safetyStocks[inputCode] * 2;
						balance -= safetyStocks[inputCode] * 2 * costs[inputCode];
						//지출등록
						expences += safetyStocks[inputCode] * 2 * costs[inputCode];
						System.out.println(" [system:log] 안전재고를 확보하였습니다.");
					}else {
						//잔고가 부족해 매입이 불가능하면 안전재고 매입을 취소한다.
						System.out.println(" [system:log] 잔고가 부족해 안전재고 확보에 실패하였습니다.");
					}
				}
				
				System.out.println("\n 제품명 : 아메리카노");
				System.out.println(" 판매가 : " + prices[inputCode] );
				System.out.println(" 판매수량 : " + orderCnt);
				System.out.println(" 결제금액 : " + (prices[inputCode] * orderCnt));
				System.out.println(" 남은 재고 : " + stocks[inputCode] );
				
			}else if(inputMenu == 2) {
				for (int i = 0; i < salesCnts.length; i++) {
					System.out.println(names[i] + "| 재고 : " + stocks[i] + "| 판매량 : " + salesCnts[i]);
				}
				
				System.out.println("잔고 : " + balance + " | 매출 : " + salesPrice 
						+ " | 지출 : " + expences);
				
			}else if(inputMenu ==3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("알맞은 번호를 입력하세요.");
			}
		}
		
		
		
		
		
		
		
		
		
		

	}

}
