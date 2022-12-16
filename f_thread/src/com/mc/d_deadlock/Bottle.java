package com.mc.d_deadlock;

public class Bottle {
	
	private String drink;
	
	// static, heap영역은 모든 thread가 공유하는 영역이다. -> 공유자원
	// 멀티쓰래드 상황에서 하나의 자원을 두고 여러 쓰래드가 경쟁하는 경쟁상태(race condition)가 발생할 수 있다.
	// 임계영역 : 코드 블록 내에서 공유자원을 사용하고 있어 둘 이상의 쓰래드가 해당 코드블록을 실행할 경우 경쟁상태가 발생할 수 있는 코드블록
	// 임계영역에 동기화를 통해 작업의 순서를 지정해줘야 한다.
	// 동기화 : 두 작업이 있을 때 A라는 작업이 끝나는 시점과 B라는 작업이 시작되는 시점이 일치하는 것
	
	// synchronized 예약어
	// 메서드 선언부, 또는 synchronized 블록을 지정
	// 메서드 선언부에 synchronized를 선언할 경우, 메서드의 코드블록(메서드 바디) 전체가 동기화
	
	// 특정 쓰래드가 synchronized 블록, 메서드를 사용하는 동안
	// 다른 쓰래드들은 synchronized 블록, 메서드에서 사용되는 객체에 접근할 수 없다. (객체에 lock을 건다.)
	public synchronized String input(String drink) {

		// synchronized  블록은 synchronized 블록 영역만큼 동기화
		synchronized (this) {
			this.drink = drink;
			System.out.println("Bottle : 물병에 " + drink + " 채운다." );
			return this.drink;
		}
		
	}
}
