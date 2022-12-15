package com.mc.d_encapsulation.before;

public class Desktop {
	
	//제조사, 상품명, 가격, cpu, ram, 일체여부
	private String brand;
	private String pName;
	private int price;
	private String cpu;
	private int ram;
	private boolean allInOne;
	
	public Desktop() {
		// TODO Auto-generated constructor stub
	}

	public Desktop(String brand, String pName, int price, String cpu, int ram, boolean allInOne) {
		super();
		this.brand = brand;
		this.pName = pName;
		this.price = price;
		this.cpu = cpu;
		this.ram = ram;
		this.allInOne = allInOne;
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

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public boolean isAllInOne() {
		return allInOne;
	}

	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
	public String toString() {
		return "Desktop [brand=" + brand + ", pName=" + pName + ", price=" + price + ", cpu=" + cpu + ", ram=" + ram
				+ ", allInOne=" + allInOne + "]";
	}
	

}
