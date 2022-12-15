package com.mc.coffeemanager.service;

public class Sales {
	
	public Payment takeOrder(Order order) {
		
		order.execute();
		Payment payment = new Payment(order);
		payment.excute();
		
		return payment;
	}

}
