package com.mc.b_control;

import java.util.Scanner;

import com.mc.a_thread.MyThread;
import com.mc.a_thread.runnable.MyDaemonThread;
import com.mc.a_thread.runnable.MyRunnable;

public class Run {
	
	public static void main(String[] args) {
		
		//Thread 상태
		// 실행, 실행대기, 일시정지, 중지
		// 실행 	: thread가 실행되고 있는 상태
		// 실행대기 : thread가 실행될 수 있는데, 아직 스케쥴링이 되지 않아서 실행을 기다리는 상태
		// 일시정지 : thread를 실행할 수 없는 상태
		//			1) waiting		 : Thread.join(), Object.wait() 메서드에 의해 멈춰진 상태
		//			2) timed wating  : 지정된 시간동안 쓰래드가 일시정지 되어진 상태. sleep(milliSeconds)
		//			3) Blocked 		 : 공유자원에 Lock이 걸려 대기하고 있는 경우
		// 중지		: thread가 작업을 마치고 중지된 상태
		
		// Thread를 제어하는 메서드
		// start() : 쓰래드를 실행대기 상태로 만들어준다.
		// yield() : 실행중인 쓰래드를 실행대기로 만들어준다.(양보)
		// sleep() : 지정된 시간동안 쓰래드를 일시정지
		// join()  : 쓰래드가 종료될 때 까지 해당 쓰래드를 호출한 쓰래드를 일시정지상태로 변경
		// interrupt() : join() 또는 sleep() 에 의해 일시정지 상태가 된 쓰래드를 실행대기로 변경
		// Object.wait() : 쓰래드를 일시정지
		// Object.notify() : Object.wait()에 의해서 일시정지된 쓰래드를 실행대기로 변경
		
		// 메인쓰래드 이름 찍어보기
		System.out.println("메인메서드가 동작하는 쓰래드 : " + Thread.currentThread().getName());
		
		// 두번째 쓰래드를 생성
		Thread m2 = new Thread(new MyRunnable());
		m2.setName("m2");
		m2.start();
		
		Thread timer = new Thread(new A_ThreadControl());
		timer.setName("타이머");
		timer.start();
		
		for (int i = 0; i < 100; i++) {
			
			if(i == 50) {
				try {
					 //main쓰래드를 일시정지 상태로 만듦
					 //m2의 쓰래드가 실행이 끝나면 main 쓰래드가 실행대기 상태로 변경
					m2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//쓰래드 이름을 출력
			System.out.println(i + ":" + Thread.currentThread().getName());
		}
		
		Scanner sc = new Scanner(System.in);
		
		while(true){
			
			System.out.println("빨리감기를 하려면 아무키나 입력하세요 :");
			sc.nextLine();
			timer.interrupt(); // 일시정지 상태인 thread를 실행상태로 변경
			
			if(!timer.isAlive()) {
				break;
			}
		}
		
		System.out.println("================================");
		System.out.println("메인 메서드의 마지막 코드");
		System.out.println("================================");
		
		
		
		
	}
}
