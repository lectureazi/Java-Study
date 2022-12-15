package com.mc.a_thread.runnable;

// Runnable 인터페이스 구현을 통해 쓰래드 생성
public class MyRunnable implements Runnable{

	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			//쓰래드 이름을 출력
			System.out.println(i + ":" + Thread.currentThread().getName());
		}
	
	}
}
