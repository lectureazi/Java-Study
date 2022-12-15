package com.mc.filter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class A_BufferedIO {
	
	//기반스트림에게 내부 버퍼를 제공해 IO 속도를 향상시켜주는 보조스트림
	public void copyFileWithBuffer() {
		
		String inputPath = "C:\\Program Files\\CODE\\CODE.zip";
		String outputPath = "./COPY.zip";
		
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputPath));
			 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputPath))) {
			
			//epoch 기준 현재시간을 밀리세컨즈로 반환
			long start = System.currentTimeMillis();
			
			int check = 0;
			while ((check = bis.read()) != -1) {
				bos.write(check);
			}
			
			long end = System.currentTimeMillis();
			System.out.println("buffer 걸린 시간 : " + (end - start));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
