package com.mc.filter;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mc.dto.Music;

public class C_ObjectIO {
	
	//ObjectOutputStream, ObjectInputStream
	public void writeObject() {
		
		//직렬화 가능한 객체만 Object IO가 가능, Serializable 인터페이스 구현
		// .dat : 데이터파일을 의미하는 확장자
		Music music = new Music("볼빨간사춘기", "우주를 줄게");
		Music music2 = new Music("아이유", "부우");
		Music music3 = new Music("아델", "롤링인더딥");
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("music.dat"))) {
			
			oos.writeObject(music);
			oos.writeObject(music2);
			oos.writeObject(music3);
			
			System.out.println("music.dat 파일 생성 완료");
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readObject() {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("music.dat"))) {
			
			while(true) {
				Object res = ois.readObject();
				System.out.println(res);
			}
			
		}catch (EOFException e) {
			System.out.println("파일의 모든 객체를 출력하였습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
