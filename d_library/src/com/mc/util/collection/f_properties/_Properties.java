package com.mc.util.collection.f_properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class _Properties {
	
	// 1.Properties
	//	XML파일 입출력을 지원하면서 Key와 Value가 String으로 고정된 Map
	
	//  XML : Extensible Markup Language
	//		 확장 가능한 마크업 언어
	//		 Markup Language : 데이터를 저장하고 전달하기 위해 디자인된 언어
	//						미리 약속된 tag를 사용해 데이터를 저장하고 식별
	//						XML은 확장가능한 마크업 언어이기 때문에, 언어차원에서 미리 정의된 tag는 없고, 사용자끼리 약속을 하면 됨
	
	//	tag :
	//		ex) <a id="t">https://www.naver.com</a>, <a id="p">https://www.daum.net</a>
	//			<a></a> : 태그
	//			<a> : 여는 태그,  </a> : 닫는 태그
	//			https://www.naver.com : 태그 사이에 있는 정보가 데이터가 된다.
	//			id="t"  			  : 태그의 속성
	//			<a id="t">https://www.naver.com</a> : 구체적인 속성과, 값을 가진 element
	
	public void studyProperties() {
		
		Properties props = new Properties();
		
		// 저장
		props.setProperty("DATE", "202212151522");
		props.setProperty("DayOfWeek", "thurs");
		props.setProperty("Time", "15:23");
		
		// 출력
		for (Object key : props.keySet()) {
			System.out.println(props.getProperty((String)key));
		}
		
		// 수정
		props.setProperty("Time", "17:50");
		
		System.out.println(" ///////////// 시간 수정 /////////////");
		for (Object key : props.keySet()) {
			System.out.println(props.getProperty((String)key));
		}
		
		// 삭제
		props.remove("Time");
		System.out.println(" ///////////// 시간 삭제 /////////////");
		for (Object key : props.keySet()) {
			System.out.println(props.getProperty((String)key));
		}
	}
	
	public void storeToXMl() {
		
		Properties props = new Properties();
		
		// 저장
		props.setProperty("DATE", "202212151522");
		props.setProperty("DayOfWeek", "thurs");
		props.setProperty("Time", "15:23");
		
		try (FileOutputStream fos = new FileOutputStream("prop.xml")) {
			
			
			props.storeToXML(fos, "date info");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadFromXML() {
		
		Properties readProp = new Properties();
		
		try (FileInputStream fis = new FileInputStream("prop.xml")) {
			
			readProp.loadFromXML(fis);
			
			for (Object key : readProp.keySet()) {
				System.out.println(readProp.getProperty((String)key));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
	}
	
	
	
	
	
	
	
	

}
