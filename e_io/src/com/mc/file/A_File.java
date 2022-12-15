package com.mc.file;

import java.io.File;
import java.io.IOException;

public class A_File {
	
	public void studyFile() {
		
		try {
			
			//1. 파일 클래스의 인스턴스 생성
			File file = new File("C:\\Program Files\\CODE\\file_test.txt");
			
			//실제로 파일을 생성해보자!
			file.createNewFile();
			
			//2. 원하는 경로(폴더)를 생성
			//mkdirs : 경로를 생성
			
			//절대경로 : root(window기준 C:\\)에서 부터 경로를 지정하는 방식
			//상대경로 : 현재 위치로부터 경로를 지정하는 방식, / 로 경로 구분
			//			현재 위치 : ./, / 
			//			상위 폴더 : ../
			
			String path = "c:\\Program Files\\CODE\\mkdirs\\study\\";
			File dirs = new File(path);
			dirs.mkdirs();
			
			File dirs2 = new File("./상대경로.txt");
			dirs2.createNewFile();
			
			dirs2 = new File("../../부모경로.txt");
			dirs2.createNewFile();
			
			dirs2 = new File("./src/src.txt");
			dirs2.createNewFile();
			
			// 상대경로를 사용하여 txt 파일을 만들어보자
			path = "../../mkdirs/";
			
			dirs2 = new File(path + "a/");
			dirs2.mkdirs();
			
			dirs2 = new File(path + "b/");
			dirs2.mkdirs();
			
			dirs2 = new File(path + "c/");
			dirs2.mkdirs();
			
			dirs2 = new File(path + "a/a.txt");
			dirs2.createNewFile();
			
			dirs2 = new File(path + "b/b.txt");
			dirs2.createNewFile();
			
			dirs2 = new File(path + "c/c.txt");
			dirs2.createNewFile();
			
			// 파일명 출력
			System.out.println(dirs2.getName());
			// 저장경로 출력
			System.out.println(dirs2.getPath());
			// 파일용량 확인
			System.out.println(dirs2.length());
			// 파일 삭제
			System.out.println(dirs2.delete());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
