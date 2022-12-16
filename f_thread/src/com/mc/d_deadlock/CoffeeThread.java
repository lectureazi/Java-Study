package com.mc.d_deadlock;

public class CoffeeThread implements Runnable{
	
	private School school;
	private Bottle bottle;

	public CoffeeThread(School school, Bottle bottle) {
		super();
		this.school = school;
		this.bottle = bottle;
	}

	@Override
	public void run() {

		while(true) {
			
			school.leaveSchool("커피소년");
			System.out.println(Thread.currentThread().getName() + " : 커피 발견!");
			System.out.println(Thread.currentThread().getName() + " : " + bottle.input("커피") + " 마신다.");
			
		}
	}
}
