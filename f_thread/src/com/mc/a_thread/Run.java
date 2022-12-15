package com.mc.a_thread;

import com.mc.a_thread.runnable.MyDaemonThread;
import com.mc.a_thread.runnable.MyRunnable;

public class Run {
	
	public static void main(String[] args) {
		
		// 메인쓰래드 이름 찍어보기
		System.out.println("메인메서드가 동작하는 쓰래드 : " + Thread.currentThread().getName());
		
		// 새로운 쓰래드를 생성하여 실행
		MyThread m1 = new MyThread();
		m1.setName("m1");
		//쓰래드를 시작, 쓰래드가 생성되고 실행될 준비가 끝나면 JVM이 run() 를 실행
		m1.start();
		
		// 두번째 쓰래드를 생성
		Thread m2 = new Thread(new MyRunnable());
		m2.setName("m2");
		m2.start();
		
		// 세번째 데몬쓰래드 생성
		Thread daemon = new Thread(new MyDaemonThread());
		daemon.setDaemon(true);
		daemon.setName("데몬쓰래드");
		daemon.start();
		
		for (int i = 0; i < 100; i++) {
			//쓰래드 이름을 출력
			System.out.println(i + ":" + Thread.currentThread().getName());
		}
		
		System.out.println("================================");
		System.out.println("메인 메서드의 마지막 코드");
		System.out.println("================================");
		
	}

}
