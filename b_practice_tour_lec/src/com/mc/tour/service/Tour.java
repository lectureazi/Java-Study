package com.mc.tour.service;

public class Tour {
	
	private Airline[] airlines;
	private Tourist tourist;
	
	public Tour(Airline[] airlines, Tourist tourist) {
		this.airlines = airlines;
		this.tourist = tourist;
	}
	
	public boolean isAble(int num) {
		return tourist.getMyMoney() >= airlines[num].getAirfare();
	}
	
	public void buyTicket(int num) {
		tourist.setMyMoney(tourist.getMyMoney() - airlines[num].getAirfare());
		tourist.setMyMile(tourist.getMyMile() + airlines[num].getMileage());
	}
	
	public int bringMyMoney() {
		return tourist.getMyMoney();
	}
	
	public int bringMyMile() {
		return tourist.getMyMile();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
