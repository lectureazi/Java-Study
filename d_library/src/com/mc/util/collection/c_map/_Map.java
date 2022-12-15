package com.mc.util.collection.c_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mc.util.collection.z_dto.Music;

import java.util.Set;

public class _Map {
	
	//Map
	
	//Key와 Value쌍(Entry) 으로 데이터를 저장
	
	//Key : 데이터를 식별하기, 접근하기 위한 데이터
	//			데이터를 식별하기 위한 값이기 때문에 중복값을 허용하지 않음
	//Value : 저장하고자 하는 데이터
	//			중복저장 허용
	
	public void studyMap() {
		//K : String, 데이터를 식별하기 편해서.
		//V : 데이터
		
		//HashMap은 Entry를 저장할 때 Hash를 사용하기 때문에 순서보장이 안된다.
		//순서보장 : LinkedHashSet
		Map<String, Music> map = new HashMap<>();
		
		//1. Map에 데이터를 추가
		map.put("백산예술대상", new Music("블랙핑크", "레드핑크"));
		map.put("골든디스크상", new Music("김경호", "오아시스"));
		map.put("연예대상", new Music("싹쓰리", "싹포"));
		
		System.out.println(map.get("연예대상"));
		System.out.println("=============================================");
		
		// Map안의 데이터를 foreach를 사용해 일괄적으로 사용해보자
		
		System.out.println("================ entrySet으로 데이터 확인 ===================");
		for (Entry<String, Music> entry : map.entrySet()) {
			System.out.println("entry : " + entry);
			System.out.println("entry.getKey() : " + entry.getKey());
			System.out.println("entry.getValue() : " + entry.getValue());
			System.out.println("----------------------------------------------------");
		}
		
		System.out.println("================ keySet으로 데이터 확인 ===================");
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
			System.out.println("----------------------------------------------------");
		}
		
		//2. Map에 저장된 데이터의 개수를 확인
		System.out.println("2. Map에 저장된 데이터의 개수를 확인");
		System.out.println(map.size());
		
		//3. Map에 저장된 데이터를 수정
		System.out.println("3. Map에 저장된 데이터를 수정");
		
		// put :추가하는 key가 map 존재하지 않을 경우 value를 추가. 
		//		존재하는 경우 key에 매핑된 이전 값을 덮어쓴다. 
		
		// replace : 특정된 key의 value값을 수정
		//			 만약 key가 존재하지 않을 경우 null을 반환하고 종료
		map.replace("연예대상", new Music("싹쓰리", "싹헌드레드"));
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
			System.out.println("----------------------------------------------------");
		}
		
		//4. Map에 저장된 키 값 중에서 "연예대상" 이라는 키값이 존재하는지 확인
		System.out.println("4. Map에 저장된 키 값 중에서 \"연예대상\" 이라는 키값이 존재하는지 확인");
		System.out.println(map.containsKey("연예대상"));
		
		//6. Map의 Value 중에서 new Music("김경호","오아시스") 데이터가 존재하는지 확인
		System.out.println("6. Map의 Value 중에서 new Music(\"김경호\",\"오아시스\") 데이터가 존재하는지 확인");
		System.out.println(map.containsValue(new Music("김경호","오아시스")));
		
		//7. Map에 저장된 데이터를 List와 Set으로 변환하여 받아보기.
		List<Music> list = new ArrayList<Music>(map.values());
		System.out.println(list);
		
		Set<Music> set = new HashSet<>(map.values());
		System.out.println(set);
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
