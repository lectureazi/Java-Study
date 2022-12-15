package com.mc.b_encapsulation.method;

public class Player {
	
	// 객체는 자율성을 지녀야 한다.
	
	private String instrument;
	
	public Player(String instrument) {
		this.instrument = instrument;
	}
	
	public void play() {
		prepare();
		playing();
		end();
		//curtainCall();
	}
	
	private void prepare() {
		System.out.println(instrument + "를 연주할 준비 중입니다.");
	}
	
	private void playing() {
		System.out.println(instrument + "를 연주하고 있습니다.");
	}
	
	private void end() {
		System.out.println(instrument + "를 마치고 관객에게 인사합니다.");
	}
	
//	public void curtainCall() {
//		System.out.println("커튼콜을 진행합니다.");
//	}
	
	
	
	
	
	
	

}
