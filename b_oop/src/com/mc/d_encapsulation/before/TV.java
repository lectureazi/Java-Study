package com.mc.d_encapsulation.before;

public class TV {
	
	//제조사, 상품명, 가격, inch(크기)
	private String brand;
	private String pName;
	private int price;
	private int inch;
	
	public TV() {
		// TODO Auto-generated constructor stub
	}

	public TV(String brand, String pName, int price, int inch) {
		super();
		this.brand = brand;
		this.pName = pName;
		this.price = price;
		this.inch = inch;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}
	
	public String toString() {
		return "Tv [brand=" + brand + ", pName=" + pName + ", price=" + price + ", inch=" + inch + "]";
	}
	
	
	
	
	

}
