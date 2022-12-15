package com.mc.f_array;

import java.util.Arrays;

public class Z_quize {
	
	public static void main(String[] args) {
		
	}
	
	private static void q1() {
		//아래 배열의 0번 인덱스와 1번 인덱스의 자리를 바꿔주세요.
		int[] iArr = {1,3,5,7,9};
		
		System.out.println("변경 전 : "+ Arrays.toString(iArr));
		
		int tmp = iArr[0];
		iArr[0] = iArr[1];
		iArr[1] = tmp;
		
		System.out.println("변경 후 : "+ Arrays.toString(iArr));
	}
	
	//[문제]
	//크기가 10인 int[]을 선언하고
	//1~100 사이의 임의의 정수를 발생시켜, 배열 공간에 기록하시오
	//기록된 10개의 값 중 가장 큰 값과 가장 작은 값을 알아내어
	//[출력양식] min : 1, max : 100 과 같은 형식으로 출력하시오.
	//메서드명 : q2
	//hint : Math클래스의 random 메서드를 활용하면 임의의 정수를 발생시킬 수 있다.
	public static void q2() {
		int[] randomArr = new int[10];
		
		//0 ~ 0.9999999999999999
		//0*100  ~ 0.999999999999 * 100
		//0 ~ 99    + 1
		//1 ~ 100
		for (int i = 0; i < randomArr.length; i++) {
			int random = (int)(Math.random()*100)+1;
			randomArr[i] = random;
		}
		
		C_ArrayUtil.asc(randomArr);
		System.out.println(Arrays.toString(randomArr));
		System.out.println("min : " + randomArr[0] + " / max : " + randomArr[randomArr.length-1]);
	}
	
	//크기가 10인 int[]를 3개 생성하세요.
	//각 int[]을 1~95 사이의 임의의 수로 초기화 하세요.
	//3개 int[]에 들어있는 숫자들 중에서 7,8,9번째로 작은 수를 구하세요
	// ex) [1,2,3,3] [4,5,5,6] [6,6,8,9]
	//[출력양식]7번째 : 5
	//			8번째 : 6
	//			9번째 : 6
	public static void q3() {
		
		int[][] dArr = new int[3][10];
		
		for (int i = 0; i < dArr.length; i++) {
			for (int j = 0; j < dArr[i].length; j++) {
				dArr[i][j] = (int)(Math.random()*95)+1;
			}
		}
		
		//3줄의 코드로 문제 해결
		int[] res = C_ArrayUtil.merge(dArr[0], dArr[1]);		
		res = C_ArrayUtil.merge(res, dArr[2]);
		C_ArrayUtil.asc(res);
		
		System.out.println(Arrays.toString(res));
		System.out.println("7번째로 작은 수 : " + res[6]);
		System.out.println("8번째로 작은 수 : " + res[7]);
		System.out.println("9번째로 작은 수 : " + res[8]);
	}

}
