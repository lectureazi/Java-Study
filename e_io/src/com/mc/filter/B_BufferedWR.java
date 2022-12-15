package com.mc.filter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class B_BufferedWR {
	
	//BufferedReader
	//BufferedWriter
	public void readWithBuffer() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("읽어올 파일명을 작성하세요 : ");
		String fileName = sc.nextLine();
		
		try (BufferedReader br =new BufferedReader(new FileReader(fileName))) {
			
			String line = "";
			StringBuffer sb = new StringBuffer();
			
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			System.out.println(sb);
			//checkEncoding(sb.toString());
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
