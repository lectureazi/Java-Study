package com.mc.exception.test;

import com.mc.exception.custom.IllegalPriceException;
import com.mc.exception.custom.TimeOutException;

//implements : 인터페이스 구현
//인터페이스는 다중구현 할 수 있다.
public class SmartPhone extends Computer implements BatteryDetachable, Communicatable{

	private String mobileAgency;
	
	public SmartPhone() {
		// TODO Auto-generated constructor stub
	}

	public SmartPhone(String brand, String pName, int price, String cpu, int ram, String mobileAgency) {
		super(brand, pName, price, cpu, ram);
		this.mobileAgency = mobileAgency;
	}

	public String getMobileAgency() {
		return mobileAgency;
	}
	
	public void setPrica(int price) {
		
		if(price < 0) throw new IllegalPriceException();
		this.price = price;
		
	}

	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}
	
	public String toString() {
		return "SmartPhone [brand=" + brand + ", pName=" + pName + ", price=" + price + ", cpu=" + cpu + ", ram=" + ram
				+ ", mobileAgency=" + mobileAgency + "]";
	}

	@Override
	public void detacheBattery() {
		System.out.println("베터리를 분리합니다.");
	}

	@Override
	public void attacheBattery() {
		System.out.println("베터리를 결합합니다.");
	}

	@Override
	public void sendMessage() throws TimeOutException {
		
		System.out.println("메세지를 보냅니다.");
		
		//만약 메세지를 보내는데 시간이 너무 많이 지연된다면 TimeOutException 예외를 발생
		if(true) {
			
			try {
				throw new TimeOutException("기지국 상태가 별로인가 봅니다.");
			} finally {
				System.out.println("연결을 완전히 종료합니다.");
			} 
		}
		
		// 다른 서버와의 통신을 완전히 종료하는 코드들...
	}

	@Override
	public void receiveMessage() {
		System.out.println("메세지를 받습니다.");
	}
	
	
}
