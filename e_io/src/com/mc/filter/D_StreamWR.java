package com.mc.filter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class D_StreamWR {
	// byte기반 Stream을 문자기반스트림인 Writer, Reader로 변경
	// InputStreamReader, OutputStreamWriter  stream => Reader, Writer로 변경

	public void toReader() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("읽어올 파일명을 작성하세요 : ");
		String fileName = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
			
			String line = "";
			StringBuffer sb = new StringBuffer();
			
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			System.out.println(sb);
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void toWriter() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("파일명 : ");
		String fileName = sc.nextLine();
		System.out.println("파일 내용을 작성하세요 : ");
		String contents = sc.nextLine();
		
		// try-with-resource : 자동으로 닫을 수 있는 객체에 한해서, 자동으로 close 처리를 해주는 구문
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)))) {
			
			bw.write(contents);
			System.out.println("파일 생성이 완료 되었습니다. 프로젝트를 새로고침하세요.");
			
		} catch (IOException e) {
			e.printStackTrace() ;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
