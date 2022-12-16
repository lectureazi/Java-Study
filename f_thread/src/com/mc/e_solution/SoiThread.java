package com.mc.e_solution;

public class SoiThread implements Runnable{
	
	private Bottle bottle;

	public SoiThread(Bottle bottle) {
		super();
		this.bottle = bottle;
	}

	@Override
	public void run() {

		School school = new School();
		Home home = new Home(school);
		school.setHome(home);
		
		while(true) {
			System.out.println(Thread.currentThread().getName() + " : 간장 발견!");
			System.out.println(Thread.currentThread().getName() + " : " + bottle.input("간장") + " 냉장고에 넣는다.");
			home.leaveHome("간장소녀");
			
		}
	}

}
