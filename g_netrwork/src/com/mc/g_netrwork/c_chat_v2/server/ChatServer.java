package com.mc.g_netrwork.c_chat_v2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class ChatServer {
	
	private ServerSocket serverSocket;
	private Map<String, Socket> socketMap;
	
	public ChatServer() {
		
		// 10.10.0.17 //  80
		 try {
			 this.serverSocket = new ServerSocket(80);
			 socketMap = Collections.synchronizedMap(new HashMap<>());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startServer() {
		
		System.out.println("서버를 시작합니다...");
		
		while(true) {
			try {
				
				Socket socket = serverSocket.accept();
				read(socket);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void read(Socket socket) {
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				String userId = "anonymous";
				
				try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
					
					while(true) {
						String message = br.readLine();
						
						if(message.startsWith("type=regist")) {
							
							// 클라이언트가 보낸 userId값을 전체 메세지에서 추출
							userId = message.substring(message.indexOf("&")+1);
							registUser(userId, socket);
							
						}else {
							broadcast(message);
						}
					}
					
				} catch (IOException e) {
					System.out.println("연결이 종료되었습니다.");
					removeSocket(userId);
				}
			}
		});
		
		thread.start();
	}

	protected void registUser(String userId, Socket socket) throws IOException {

		if(socketMap.containsKey(userId)) {
			String message = "auth=false";
			write(socket, message);
			
		}else {
			String message = "auth=true";
			write(socket, message);
			//socketMap에 추가되는 순간부터, socket은 broadcast의 대상이 됨
			socketMap.put(userId, socket);
		}
	}

	private void write(Socket socket, String message) throws IOException {
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		writer.println(message);
		writer.flush();
	}

	protected void broadcast(String message) {
		
		for (Entry<String, Socket> socket : socketMap.entrySet()) {
			
			try{
				PrintWriter writer = new PrintWriter(socket.getValue().getOutputStream());
				writer.println(message);
				writer.flush();
			} catch (IOException e) {
				removeSocket(socket.getKey());
			}
		}
		
	}

	private void removeSocket(String userId) {

		System.out.println("접속인원 : " + socketMap.size());
		System.out.println("=============================");
		System.out.println(userId + " is closed");
		
		try {
			socketMap.remove(userId).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("=============================");
		System.out.println("접속인원 : " + socketMap.size());
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
