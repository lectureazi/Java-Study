package com.mc.util.collection.c_map.mc;

import java.util.Map.Entry;

import com.mc.util.collection.z_dto.Music;

public class Run {
	
	public static void main(String[] args) {
		
		McMap<String, Music> map = new McMap<String, Music>();
		
		//1. Map에 데이터를 추가
		map.put("백산예술대상", new Music("블랙핑크", "레드핑크"));
		map.put("골든디스크상", new Music("김경호", "오아시스"));
		map.put("연예대상", new Music("싹쓰리", "싹포"));
		
		System.out.println("===============================================");
		for (Entry<String, Music> node : map.entrySet()) {
			System.out.println(node);
		}
		
		System.out.println("===============================================");
		System.out.println(map.get("연예대상"));
		
		
		//2. Map에 저장된 데이터의 개수를 확인
		System.out.println("\n=============2. Map에 저장된 데이터의 개수를 확인=========");
		System.out.println(map.size());
		

		//3. Map에 저장된 데이터를 수정
		System.out.println("\n=============3. Map에 저장된 데이터를 수정================");
		map.replace("연예대상", new Music("이승철", "소녀시대"));
		
		for (Entry<String, Music> node : map.entrySet()) {
			System.out.println(node);
		}
		
		//4. Map에 저장된 데이터를 삭제
		System.out.println("\n=============4. Map에 저장된 데이터를 삭제================");
		map.remove("연예대상");
		
		for (Entry<String, Music> node : map.entrySet()) {
			System.out.println(node);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
