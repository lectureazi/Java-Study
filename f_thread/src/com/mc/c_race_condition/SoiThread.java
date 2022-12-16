package com.mc.c_race_condition;

public class SoiThread implements Runnable{
	
	private Bottle bottle;

	public SoiThread(Bottle bottle) {
		super();
		this.bottle = bottle;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10000; i++) {
			
			System.out.println(Thread.currentThread().getName() + " : 간장 발견!");
			System.out.println(Thread.currentThread().getName() + " : " + bottle.input("간장") + " 냉장고에 넣는다.");
			
		}
	}

}
