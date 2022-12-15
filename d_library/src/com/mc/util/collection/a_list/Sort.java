package com.mc.util.collection.a_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.mc.util.collection.z_dto.Student;

public class Sort {
	
	public static void main(String[] args) {
		
		List<Student> students = getStudentList();
		
		//1. Collections : Collection 인스턴스를 다루기위한 util 클래스
		Collections.sort(students);

		for (Student student : students) {
			System.out.println(student);
		}

		System.out.println("========================================================");
		
		//2. list.sort 를 사용하여 정렬
		//   나이로 내림차순 정렬하되, 만약 나이가 같다면 이름으로 내림차순 정렬
		students.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getAge() == o2.getAge()) return o2.getName().compareTo(o1.getName());
				return o2.getAge() - o1.getAge();
			}
		});
		
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	
	private static List  getStudentList() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("강유리",11));
		students.add(new Student("경제원",12));
		students.add(new Student("권용구",13));
		students.add(new Student("김시은",14));
		students.add(new Student("방민성",15));
		students.add(new Student("배재현",16));
		students.add(new Student("서지현",17));
		students.add(new Student("신비",18));
		students.add(new Student("신유진메니저",19));
		students.add(new Student("여태양",11));
		students.add(new Student("유승민",12));
		students.add(new Student("윤혁",13));
		students.add(new Student("이대희",14));
		students.add(new Student("이도명",15));
		students.add(new Student("이리안",16));
		students.add(new Student("이준형",17));
		students.add(new Student("장이주",18));
		students.add(new Student("정다솜",19));
		students.add(new Student("진혜원",11));
		students.add(new Student("최호근",12));
		students.add(new Student("황현중",13));
		return students;
	}
}
