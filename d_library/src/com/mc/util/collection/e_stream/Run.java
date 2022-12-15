package com.mc.util.collection.e_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mc.util.collection.z_dto.Test;

public class Run {
	
	//Stream 데이터 처리 연산을 제공
	public static void main(String[] args) {
		
		// Stream 생성
		Stream<Integer> iStream = Stream.<Integer>builder().add(11).add(12).add(13).add(14).build();
		
		List<Test> list = new ArrayList<>();
		list.add(new Test("국어", "하명도", 90));
		list.add(new Test("수학", "하명도", 70));
		list.add(new Test("영어", "하명도", 65));
		list.add(new Test("과학", "하명도", 46));
		
		//1. sort 
		List<Test> res = list.stream()											// stream 객체 생성
				.sorted((a, b) -> a.getSubject().compareTo(b.getSubject()))		// intermediate operation, 가공, 중간연산 : stream 내부에서 연산을 수행
				.collect(Collectors.toList());									// terminal operation, 결과, 연산의 결과값을 받는 작업을 수행
		
		System.out.println("1. sort ");
		for (Test test : list) {
			System.out.println(test);
		}
		
		//2. foreach
		// 메서드 참조 
		// :: 을 사용해서 코드를 축약할 수 있다.
		// lamda의 구현 코드가 특정 메서드를 호출하는 용도로 사용 될 때
		// a -> System.out.println(a) 
		// System.out::println 
		System.out.println("2. foreach ");
		list.stream().forEach(System.out::println);
				
		
		//3. filter
		//   조건에 맞는 요소만 필터링하기 위해 사용
		System.out.println("3. filter");
		// 시험점수가 70점 이상인 요소만 담긴 list를 반환
		res = list.stream()
				.filter(a -> a.getScore() >= 70)
				.collect(Collectors.toList());
		
		res.stream().forEach(System.out::println);
		
		//4. map
		System.out.println("4. map");
		
		//Test List에서 학생들의 성만 추출하여 저장한 List를 만드세요
		List<String> res2 = list.stream()
							.map(a -> a.getName().substring(0,1))
							.collect(Collectors.toList());
		
		res2.forEach(System.out::println);

		//5. reduce 
		System.out.println("5. reduce");
		
		//reduce​(T identity, BinaryOperator<T> accumulator)
		//	누적연산을 시작하기 위한 초기값
		Integer res3 = iStream
				.reduce(0, (a, b) -> {
					System.out.println("기준 값 : " + a);
					System.out.println("요소 값 : " + b);
					return a+b;});
		
		System.out.println(res3);
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
