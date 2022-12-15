package com.mc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C_FileWR {
	
	//문자기반스트림
	//FileWriter
	public void writeFile() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("파일명 : ");
		String fileName = sc.nextLine();
		System.out.println("파일 내용을 작성하세요 : ");
		String contents = sc.nextLine();
		
		// try-with-resource : 자동으로 닫을 수 있는 객체에 한해서, 자동으로 close 처리를 해주는 구문
		try (FileWriter fw = new FileWriter(fileName, true)) {
			
			fw.write(contents);
			System.out.println("파일 생성이 완료 되었습니다. 프로젝트를 새로고침하세요.");
			
		} catch (IOException e) {
			e.printStackTrace() ;
		}
		
	}
	
	//FileReader
	public void readFile() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("읽어올 파일명을 작성하세요 : ");
		String fileName = sc.nextLine();
		
		try (FileReader fr = new FileReader(fileName)) {
		
			int check = 0;
			StringBuffer sb = new StringBuffer();
			while((check = fr.read()) != -1) {
				sb.append((char)check);
			}
			
			System.out.println(sb);
			//checkEncoding(sb.toString());
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
