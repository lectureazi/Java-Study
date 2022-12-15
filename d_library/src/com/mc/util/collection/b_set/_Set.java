package com.mc.util.collection.b_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.mc.util.collection.z_dto.Music;

public class _Set {
	
	Set<Music> setA = new LinkedHashSet<>();
	Set<Music> setB = new HashSet<>();
	
	//Set
	//Set은 집합연산을 위해 만들어진 자료구조
	//저장되는 값들의 순서를 유지하지 않는다.
	//저장되는 값들의 중복을 허용하지 않는다.
	//구현 클래스  : HashSet, LinkedHashSet(순서가 유지되는 Set)
	public void studySet() {
		union();
		intersection();
		difference();
		
		//4. 부분집합 여부 확인
		System.out.println("부분집합 여부 : " + setA.containsAll(setB));
		
		
		// tip : 다른 컬랙션에 저장된 요소들의 중복제거가 필요할 때 set을 사용해 간단하게 중복제거가 가능
		List<String> sList = List.of("가", "가", "나", "다","다");
		sList = new ArrayList<String>(new LinkedHashSet<>(sList)); 
		
		for (String string : sList) {
			System.out.println(string);
		}
	}

	private void difference() {
		Set<Music> tmp1 = new HashSet<Music>(setA);
		Set<Music> tmp2 = new HashSet<Music>(setB);
		
		System.out.println("차집합------------------------------");
		tmp1.removeAll(tmp2);
		for (Music music : tmp1) {
			System.out.println(music);
		}
	}

	private void intersection() {
		Set<Music> tmp1 = new HashSet<Music>(setA);
		Set<Music> tmp2 = new HashSet<Music>(setB);
		
		System.out.println("교집합------------------------------");
		tmp1.retainAll(tmp2);
		for (Music music : tmp1) {
			System.out.println(music);
		}
	}

	private void union() {
		Set<Music> tmp1 = new HashSet<Music>(setA);
		Set<Music> tmp2 = new HashSet<Music>(setB);
		
		System.out.println("합집합------------------------------");
		tmp1.addAll(tmp2);
		
		for (Music music : tmp1) {
			System.out.println(music);
		}
	}
	
	public _Set() {
		Music music1 = new Music("백지영", "총 맞은 것 처럼");
		Music music2 = new Music("윤도현", "사랑했나봐");
		Music music3 = new Music("김경호", "금지된 사랑");
		Music music4 = new Music("김경호", "금지된 사랑");
		
		Music music5 = new Music("김경호", "금지된 사랑");
		Music music6 = new Music("라나델레이", "썸머타임새드니스");
		Music music7 = new Music("아델", "롤링인더딥");
		Music music8 = new Music("박정현", "꿈에");
		
		setA.add(music1);
		setA.add(music2);
		setA.add(music3);
		setA.add(music4);
		
		setB.add(music5);
		setB.add(music6);
		setB.add(music7);
		setB.add(music8);
		
		for (Music music : setA) {
			System.out.println(music);
		}
		
		System.out.println("---------------------------------------------");
		
		for (Music music : setB) {
			System.out.println(music);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
