package com.mc.e_solution;

public class School {
	
	private Home home;
	
	public School() {
		// TODO Auto-generated constructor stub
	}

	public School(Home home) {
		super();
		this.home = home;
	}
	
	public synchronized void goToSchool(String name) {
		System.out.println(name + " 학교로 가는 중...");
	}
	
	public synchronized void leaveSchool(String name) {
		System.out.println(name + " 학교를 떠나 집으로 갑니다.");
		home.goToHome(name);
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}





}
