package com.mc.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class D_PrintWriter {
	
	public void printWriter() {
		
		// System.in  : 표준입력장치(키보드)로 부터 데이터를 입력받는 스트림 
		// System.out : 표준출력장치(모니터)로 데이터를 출력하는 스트림
		Scanner sc = new Scanner(System.in);
		
		System.out.println("파일명 : ");
		String fileName = sc.nextLine();
		System.out.println("파일 내용을 작성하세요 : ");
		String contents = sc.nextLine();
		
		// try-with-resource : 자동으로 닫을 수 있는 객체에 한해서, 자동으로 close 처리를 해주는 구문
		try (PrintWriter pw = new PrintWriter(fileName)) {
			
			pw.println(contents);
			System.out.println("파일 생성이 완료 되었습니다. 프로젝트를 새로고침하세요.");
			
		} catch (IOException e) {
			e.printStackTrace() ;
		}
	}

}
