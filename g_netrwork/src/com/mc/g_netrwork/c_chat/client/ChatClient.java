package com.mc.g_netrwork.c_chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ChatClient {
	
	private Socket socket;
	
	public ChatClient() {}
	
	public void startChat() {
		connect();
		write();
		read();
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
			}
			
		}).start();
	}

	private void write() {
		new Thread(() -> {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("닉네임 : ");
			String userId = sc.nextLine();
			
			try(PrintWriter writer = new PrintWriter(socket.getOutputStream())){
				
				while(true) {
					String message = sc.nextLine();
					System.out.println();
					writer.println(userId + " : " + message);
					writer.flush();
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
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
	
	

}
