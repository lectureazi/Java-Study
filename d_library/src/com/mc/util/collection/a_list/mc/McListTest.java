package com.mc.util.collection.a_list.mc;

import java.util.Iterator;

import com.mc.util.collection.z_dto.Music;
import com.mc.util.collection.z_dto.Student;

public class McListTest {
	
	public void studyList() {
		
		// 1.8 이전에는 레퍼런스 타입에도 제네릭 타입을 명시 해야 했으나
		// 1.8 이후로 부터 인스턴스화 하는 생성자에만 명시해도 괜찮음
		McList<Music> list = new McList<>();
		
		Music music = new Music("백지영", "총 맞은 것 처럼");
		Music music2 = new Music("윤도현", "사랑했나봐");
		Music music3 = new Music("김경호", "금지된 사랑");
		
		list.add(music);
		list.add(music2);
		list.add(music3);
		
		//2. list의 크기를 출력하세요.
		System.out.println("2. list의 크기를 출력하세요. : " + list.size());
		System.out.println("------------------------------------------------");
		
		//4. list의 2번 인덱스에 저장된 값을 받아서 출력하세요.
		System.out.println("4. list의 2번 인덱스에 저장된 값을 받아서 출력하세요. : \n" + list.get(2));
		System.out.println("------------------------------------------------");
				
		//5. 2번 인덱스에 담긴 데이터를 new Music("아이유","너랑나") 로 수정하세요		
		list.set(2, new Music("윤하", "사건의 지평선"));
		System.out.println("5. 2번 인덱스에 담긴 데이터를 new Music(\"윤하\",\"사건의 지평선\") 로 수정하세요 : \n" + list.get(2));
		System.out.println(list);
		System.out.println("------------------------------------------------");
				
		//6. 2번 인덱스에 담긴 데이터를 삭제하세요.		
		list.remove(2);
		System.out.println("6. 2번 인덱스에 담긴 데이터를 삭제하세요. : \n" + list);
		System.out.println("------------------------------------------------");
		
		System.out.println(list.get(9));
		
		// foreach 내부 구현은 아래와 같다.
//		Iterator<Music> iterator = list.iterator(); 
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
				

	}
}
