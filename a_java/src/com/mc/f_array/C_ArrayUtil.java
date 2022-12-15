package com.mc.f_array;

import java.util.Arrays;

public class C_ArrayUtil {

	public static void main(String[] args) {
		int[] data = {1,2,3,4,5};  
		data = subArr(data, 1,4);  
		System.out.println(Arrays.toString(data));
	}
	
	//기능 : 원하는 인덱스의 데이터를 삭제하는 메서드
	//첫번째 매개변수 : 배열
	//두번째 매개변수 : 인덱스
	//메서드 명 : remove
	//ex) int[] data = {1,2,3,4,5};
	//    remove(data,2) -> [1,2,4,5]
	public static int[] remove(int[] arr, int idx) {
		
		int[] temp = new int[arr.length - 1];
		
		int tidx = 0;
		for (int i = 0; i < arr.length; i++) {
			if(i == idx) continue;
			temp[tidx] = arr[i];
			tidx++;
		}
		
		return temp;
	}
	
	
	//기능 : 원하는 인덱스 구간의 데이터를 잘라내는 메서드
	//인덱스 구간 : 시작 인덱스 ~ 끝 인덱스의 앞 인덱스까지의 데이터
	//첫번째 매개변수 : 배열
	//두번째 매개변수 : 시작 인덱스
	//세번째 매개변수 : 끝 인덱스
	//메서드 명 : subArr
	//ex) int[] data = {1,2,3,4,5}
	//	subArr(data,0,2); -> [1,2]
	public static int[] subArr(int[] arr, int start, int end) {
		
		int[] temp = new int[end-start]; //b
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = arr[start+i];
		}
		
		return temp;
	}
	
	// 기능 : 매개변수로 넘어온 두 int배열을 하나의 배열로 합쳐주는 메서드
	// 메서드 이름 : merge
	// 메서드를 작성하고 테스트까지 완료 해주세요.
	// ex) int[] data = {1,2,3,4,5}
	//	   int[] data2 = {6,7,8,9,0}
	//    merge(data,data2) -> [1,2,3,4,5,6,7,8,9,0]
	public static int[] merge(int[] arr1, int[] arr2) {
		
		//매개변수로 전달받은 두 배열의 크기를 합친 크기의 새로운 배열을 생성
		int[] bigArr = new int[arr1.length + arr2.length];
		
		//두 배열에 있는 값들을 새로운 배열에 밀어넣는다.
		for (int i = 0; i < arr1.length; i++) {
			bigArr[i] = arr1[i];
		}
		
		for (int i = 0; i < arr2.length; i++) {
			bigArr[arr1.length + i] = arr2[i];
		}
		
		//새로운 배열을 반환한다.
		return bigArr; //없음
	}
	
	
	public static int[] add(int[] iArr, int num) {
		int[] bigArr = new int[iArr.length+1];
		
		for (int i = 0; i < iArr.length; i++) {
			bigArr[i] = iArr[i];
		}
		
		bigArr[bigArr.length -1] = num;
		return bigArr;
	}
	
	
	public static void asc(int[] iArr) {
		
		for (int i = 0; i < iArr.length; i++) {
			boolean flg = true;
			
			for (int j = 0; j < iArr.length-1-i; j++) {
				if(iArr[j] > iArr[j+1]) {
					int tmp = iArr[j];
					iArr[j] = iArr[j+1];
					iArr[j+1] = tmp;
					flg = false;
				}
			}
			
			if(flg) break;
		}
	}
	
	public static void desc(int[] iArr) {
		
		for (int i = 0; i < iArr.length; i++) {
			boolean flg = true;
			
			for (int j = 0; j < iArr.length-1-i; j++) {
				if(iArr[j] < iArr[j+1]) {
					int tmp = iArr[j];
					iArr[j] = iArr[j+1];
					iArr[j+1] = tmp;
					flg = false;
				}
			}
			
			if(flg) break;
		}
	}

	
}
