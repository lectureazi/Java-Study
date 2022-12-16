package com.mc.g_netrwork.c_chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
	
	private ServerSocket serverSocket;
	private List<Socket> socketList;
	
	public ChatServer() {
		
		// 10.10.0.17 //  80
		 try {
			 this.serverSocket = new ServerSocket(80);
			 socketList = Collections.synchronizedList(new ArrayList<Socket>());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startServer() {
		
		System.out.println("서버를 시작합니다...");
		
		while(true) {
			try {
				Socket socket = serverSocket.accept();
				
				// 새로운 클라인트를 추가
				socketList.add(socket);
				System.out.println("====================================");
				System.out.println("입장인원 : " + socketList.size());
				System.out.println("====================================");
				
				read(socket);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void read(Socket socket) {
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
					while(true) {
						String message = br.readLine();
						
						if(message != null) {
							broadcast(message);
						}
					}
				} catch (IOException e) {
					System.out.println("연결이 종료되었습니다.");
				}
			}
		});
		
		thread.start();
	}

	protected void broadcast(String message) {
		
		for (Socket socket : socketList) {
			
			try{
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				writer.println(message);
				writer.flush();
			} catch (IOException e) {
				removeSocket(socket);
			}
		}
		
	}

	private void removeSocket(Socket socket) {

		System.out.println("접속인원 : " + socketList.size());
		System.out.println("=============================");
		System.out.println(socket.getInetAddress().getHostAddress() + " is closed");
		
		try {
			socketList.remove(socket);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("=============================");
		System.out.println("접속인원 : " + socketList.size());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
