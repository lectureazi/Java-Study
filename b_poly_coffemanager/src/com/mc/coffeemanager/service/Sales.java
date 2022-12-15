package com.mc.coffeemanager.service;

/**
 * 판매 
 * @since 2022.12.06
 * @version 0.1
 * @author student
 *
 */
public class Sales {
	
	/**
	 * 메뉴에서 고객의 주문에 따른 판매 로직 진행 	
	 * @param order
	 * @return payment
	 */
	public Payment takeOrder(Order order) {
		
		order.execute();
		Payment payment = new Payment(order);
		payment.excute();
		
		return payment;
	}

}
