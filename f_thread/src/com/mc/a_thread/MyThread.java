package com.mc.a_thread;

public class MyThread extends Thread{

	
	// 새롭게 시작될 쓰래드의 main 메서드 역할
	
	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			//쓰래드 이름을 출력
			System.out.println(i + ":" + getName());
		}
		
	}
	
}
