package com.mc.j_inner;

public class Car {
	
	private String name;
	private int price;
	private String size;
	
	//inner 클래스를 사용해서 속성을 초기화
	//가급적, 외부클래스 안에서만 inner instance클래스를 사용하는 편이 좋다.
	//바깥에서 inner instance클래스를 사용할 경우, 내부클래스가 외부클래스를 참조하기 때문에 메모리 상에서 둘 중 하나라도 
	//내려가지 않으면 두 객체 모두 내려가지 않게 된다.
	
	public class Builder{
		
		public Builder name(String name) {
			//필드변수에 접근해서 초기화
			//내부클래스에서 외부클래스의 필드에 접근
			Car.this.name = name;
			return this;
		}
		
		public Builder price(int price) {
			Car.this.price = price;
			return this;
		}
		
		public Builder size(String size) {
			Car.this.size = size;
			return this;
		}
	}
	
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + ", size=" + size + "]";
	}
	
	

}
