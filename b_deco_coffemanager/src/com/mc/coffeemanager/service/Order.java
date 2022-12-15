package com.mc.coffeemanager.service;

import java.time.LocalDateTime;

import com.mc.coffeemanager.service.code.OrderStatus;


public class Order {
	
	private Coffee coffee; // 주문한 커피
	private int orderCnt;
	private LocalDateTime orderTime;
	private int orderPrice;
	private String orderTitle; //주문명
	private OrderStatus status;
	
	public static Order createOrder(Coffee coffee, int orderCnt) {
		Order order = new Order(coffee, orderCnt);
		order.status = OrderStatus.checkOrderStatus(coffee, orderCnt);;
		return order;
	}
	
	private Order(Coffee coffee, int orderCnt) {
		super();
		this.coffee = coffee;
		this.orderCnt = orderCnt;
		this.orderTitle = coffee.getName() + "[" + orderCnt + "잔]";
		this.orderTime = LocalDateTime.now(); //현재 시간
		this.orderPrice = coffee.getPrice() * orderCnt;
	}
	
	public void execute() {
		coffee.offer(orderCnt);
	}
	
	public OrderStatus getStatus() {
		return status;
	}

	public Coffee getCoffee() {
		return coffee;
	}
	
	public int getOrderCnt() {
		return orderCnt;
	}
	
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	
	public int getOrderPrice() {
		return orderPrice;
	}
	
	public String getOrderTitle() {
		return orderTitle;
	}
	
	@Override
	public String toString() {
		return "Order [coffee=" + coffee + ", orderCnt=" + orderCnt + ", orderTime=" + orderTime + ", orderPrice="
				+ orderPrice + ", orderTitle=" + orderTitle + "]";
	}
	
	
	

}
