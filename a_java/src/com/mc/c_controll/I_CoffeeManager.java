package com.mc.c_controll;

import java.util.Scanner;

public class I_CoffeeManager {

	public static void main(String[] args) {
		
		int balance = 100000;//잔고 100000
		int salesPrice = 0;//매출
		int expences = 0;//지출
		
		int americanoPrice = 3000; 	//아메리카노 판매가 3000
		int americanoCost = 2000;	//아메리카노 매입가 2000
		int americanoStock = 10;	//아메리카노 재고 10
		int americanoSaftyStock = 3;	//아메리카노 안전재고 3
		int americanoSalesCnt = 0;	//아메리카노 판매량 
		
		int mocaPrice = 4000; 	//모카 판매가 4000
		int mocaCost = 3000;	//모카 매입가 3000
		int mocaStock = 10;		//모카 재고 10
		int mocaSaftyStock = 3;	//모카 안전재고 3
		int mocaSalesCnt = 0;	//모카 판매량 
		
		int lattePrice = 5000; 	//라떼 판매가 5000
		int latteCost = 4000;	//라떼 매입가 4000
		int latteStock = 10;		//라떼 재고 10
		int latteSaftyStock = 3;	//라떼 안전재고 3
		int latteSalesCnt = 0;	//라떼 판매량 
		
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
				System.out.println("\n아메리카노(1)");
				System.out.println("모카(2)");
				System.out.println("라떼(3)");
				
				System.out.print("\n * 판매한 커피코드 : ");
				int inputCode = sc.nextInt();
				System.out.print(" * 판매량 : ");
				int orderCnt = sc.nextInt();
				
				if(inputCode == 1) {
	
					if(orderCnt > americanoStock) {
						//주문량이 재고보다 많으면 주문을 취소한다.
						System.out.println("재고가 부족해 주문을 취소합니다.");
						continue;
					}
					
					//주문량이 재고보다 적거나 같으면 판매 수량만큼 재고를 차감하고, 
					//잔고에 판매 금액을 반영한다.
					americanoStock -= orderCnt;
					balance += americanoPrice * orderCnt;			
					salesPrice += americanoPrice * orderCnt;
					americanoSalesCnt += orderCnt;
					
					//커피 재고가 안전재고 미만이 되면 안전재고의 두 배 만큼 매입한다.
					if(americanoStock < americanoSaftyStock) {
						
						if(balance > americanoSaftyStock * 2 * americanoCost) {
							americanoStock += americanoSaftyStock * 2;
							balance -= americanoSaftyStock * 2 * americanoCost;
							//지출등록
							expences += americanoSaftyStock * 2 * americanoCost;
							System.out.println(" [system:log] 안전재고를 확보하였습니다.");
						}else {
							//잔고가 부족해 매입이 불가능하면 안전재고 매입을 취소한다.
							System.out.println(" [system:log] 잔고가 부족해 안전재고 확보에 실패하였습니다.");
						}
					}
					
					System.out.println("\n 제품명 : 아메리카노");
					System.out.println(" 판매가 : " + americanoPrice );
					System.out.println(" 판매수량 : " + orderCnt);
					System.out.println(" 결제금액 : " + (americanoPrice * orderCnt));
					System.out.println(" 남은 재고 : " + americanoStock );
					
				}else if(inputCode == 2) {
					
					if(orderCnt > mocaStock) {
						//주문량이 재고보다 많으면 주문을 취소한다.
						System.out.println("재고가 부족해 주문을 취소합니다.");
						continue;
					}
					
					//주문량이 재고보다 적거나 같으면 판매 수량만큼 재고를 차감하고, 
					//잔고에 판매 금액을 반영한다.
					mocaStock -= orderCnt;
					balance += mocaPrice * orderCnt;
					//매출등록
					salesPrice += mocaPrice * orderCnt;
					mocaSalesCnt += orderCnt;
					
					//커피 재고가 안전재고 미만이 되면 안전재고의 두 배 만큼 매입한다.
					if(mocaStock < mocaSaftyStock) {
						
						if(balance > mocaSaftyStock * 2 * mocaCost) {
							mocaStock += mocaSaftyStock * 2;
							balance -= mocaSaftyStock * 2 * mocaCost;
							//지출등록
							expences += mocaSaftyStock * 2 * mocaCost;
							System.out.println(" [system:log] 안전재고를 확보하였습니다.");
						}else {
							//잔고가 부족해 매입이 불가능하면 안전재고 매입을 취소한다.
							System.out.println(" [system:log] 잔고가 부족해 안전재고 확보에 실패하였습니다.");
						}
					}
					
					System.out.println("\n 제품명 : 모카");
					System.out.println(" 판매가 : " + mocaPrice );
					System.out.println(" 판매수량 : " + orderCnt);
					System.out.println(" 결제금액 : " + (mocaPrice * orderCnt));
					System.out.println(" 남은 재고 : " + mocaStock );
				
				}else if(inputCode == 3) {
					if(orderCnt > latteStock) {
						//주문량이 재고보다 많으면 주문을 취소한다.
						System.out.println("재고가 부족해 주문을 취소합니다.");
						continue;
					}
					
					//주문량이 재고보다 적거나 같으면 판매 수량만큼 재고를 차감하고, 
					//잔고에 판매 금액을 반영한다.
					latteStock -= orderCnt;
					balance += lattePrice * orderCnt;
					//매출등록
					salesPrice += lattePrice * orderCnt;
					latteSalesCnt += orderCnt;
					
					//커피 재고가 안전재고 미만이 되면 안전재고의 두 배 만큼 매입한다.
					if(latteStock < latteSaftyStock) {
						
						if(balance > latteSaftyStock * 2 * latteCost) {
							latteStock += latteSaftyStock * 2;
							balance -= latteSaftyStock * 2 * latteCost;
							//지출등록
							expences += latteSaftyStock * 2 * latteCost;
							System.out.println(" [system:log] 안전재고를 확보하였습니다.");
						}else {
							//잔고가 부족해 매입이 불가능하면 안전재고 매입을 취소한다.
							System.out.println(" [system:log] 잔고가 부족해 안전재고 확보에 실패하였습니다.");
						}
					}
					
					System.out.println("\n 제품명 : 라떼");
					System.out.println(" 판매가 : " + lattePrice );
					System.out.println(" 판매수량 : " + orderCnt);
					System.out.println(" 결제금액 : " + (lattePrice * orderCnt));
					System.out.println(" 남은 재고 : " + latteStock );
				}else {
					System.out.println("올바른 메뉴를 선택해 주세요.");
					continue;
				}
				
			}else if(inputMenu == 2) {
				
				System.out.println("\n아메리카노 재고 :" + americanoStock
									+ " | 판매량 : " + americanoSalesCnt);
				
				System.out.println("모카 재고 :" + mocaStock
						+ " | 판매량 : " + mocaSalesCnt);
				
				System.out.println("라떼 재고 :" + latteStock
						+ " | 판매량 : " + latteSalesCnt);
				
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
