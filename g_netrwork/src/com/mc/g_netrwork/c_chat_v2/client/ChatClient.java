package com.mc.g_netrwork.c_chat_v2.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ChatClient {
	
	private Socket socket;
	private String userId;
	
	public ChatClient() {}
	
	public void startChat() {
		connect();
		registUser();
		write();
		read();
	}

	private void registUser() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				
				System.out.print("닉네임 : ");
				String userId = sc.nextLine();
				
				// 서버에게 알려줘야하는 정보
				//  이 메세지는 채팅메세지가 아니라, 사용자 등록을 위한 메세지이다. 따라서 브로드캐스트하지마
				//	메세지 앞에 type=regist header 추가, 이 메세지가 등록용임을 알림
				//	header와 body는 & 로 구분
				
				String message = "type=regist&" + userId;
				writer.println(message);
				writer.flush();
				
				// userId 정보를 서버에 전송
				// 해당 ID가 이미 등록된 아이디라면 다시 등록 하도록 서버측에서 메시지 전송
				//			다시 등록해야 할 경우 : auth=false
				// 해당 ID가 무사히 Map에 저장이 되었다면, 환영 메세지 출력 이후 채팅시작.
				//			성공한 경우			  : auth=true
				String response = br.readLine();
				
				if(response.equals("auth=true")) {
					System.out.println(userId + "님 환영합니다.");
					break;
				}
				
				System.out.println("이미 존재하는 아이디 입니다.");
				
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
			closeSocket();
		}
		
		
		
		
		
	}

	private void read() {
		new Thread(() -> {
			
			try(BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
				
				while(true) {
					String message = br.readLine();
					System.out.println(message);
				}
				
			} catch (IOException e) {
				System.out.println("연결이 종료되었습니다.");
				closeSocket();
			}
			
		}).start();
	}

	private void write() {
		new Thread(() -> {
			Scanner sc = new Scanner(System.in);
			
			
			
			try(PrintWriter writer = new PrintWriter(socket.getOutputStream())){
				
				while(true) {
					String message = sc.nextLine();
					writer.println(userId + " : " + message);
					writer.flush();
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
				closeSocket();
			}
			
		}).start();
	}

	private void connect() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("연결할 서버의 IP : ");
		String host = sc.nextLine();
		
		System.out.print("연결할 서버의 port : ");
		int port = sc.nextInt();
		
		try {
			this.socket = new Socket(host,port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void closeSocket() {
		try {
			socket.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

}
