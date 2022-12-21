package com.mc.g_netrwork.c_chat_v2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
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
						
						//socket연결이 끊기면, 더이상 스트림에서 읽어올 데이터가 없기 때문에, readLine이 null을 반환
						if(message == null) break;
						
						String header = message.substring(0, message.indexOf("&")+1);
						String body = message.replace(header, "");
						
						if(header.startsWith("type=regist")) {
							
							// 클라이언트가 보낸 userId값을 전체 메세지에서 추출
							String tmp = message.substring(message.indexOf("&")+1);
							if(registUser(tmp, socket)) userId = tmp;
						
						}else if(header.startsWith("type=dm")) {
							
							// 보낼 사용자 아이디를 추출
							// dm <to> / message
							String to = body.substring(body.indexOf(" "), body.indexOf("/")).trim();
							String chat = body.substring(body.indexOf("/")+1).trim();
							sendDM(to, userId, chat);
							
						}else {
							broadcast(userId + ":" + body);
						}
					}
					
				} catch (IOException e) {
					
					System.out.println("연결이 종료되었습니다.");

					if(userId.equals("anonymous")) {
						closeSocket(socket);
					}else {
						removeSocket(userId);
					}
				}
			}
		});
		
		thread.start();
	}

	protected void sendDM(String to, String userId, String message) throws IOException {
		
		if(!socketMap.containsKey(to)) {
			write(socketMap.get(userId), "존재하지 않는 사용자입니다.");
			return;
		}
		
		write(socketMap.get(to), "from " + userId + " : " + message);
	}

	protected boolean registUser(String userId, Socket socket){
		
			try {
				
				if(socketMap.containsKey(userId)) {
					String message = "auth=false";
					write(socket, message);
					return false;
				}
				
				String message = "auth=true";
				write(socket, message);
				//socketMap에 추가되는 순간부터, socket은 broadcast의 대상이 됨
				socketMap.put(userId, socket);
				
			} catch (IOException e) {
				e.printStackTrace();
				closeSocket(socket);
			}
			
			return true;			
	}

	private void closeSocket(Socket socket) {
		try {
			socket.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		
		System.out.println("=============================");
		System.out.println(userId + " is closed");
		System.out.println(socketMap.get(userId));
		
		closeSocket(socketMap.remove(userId));
		System.out.println("접속인원 : " + socketMap.size());
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
