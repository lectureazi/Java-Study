package com.mc.g_netrwork.b_tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class TCPServer {
	
	public void serverStart() {
		
		// 1. 서버의 포트번호 지정
		int port = 8989;
		
		// 2. ServerSocket
		//		소켓은 1:1 통신, 클라이언트가 서버에 하나 붙을때 마다 소켓이 하나씩 생성
		//		ServerSocket은 클라이언트의 최초 요청을 받기위한 특수한 소켓
		//		클라이언트의 최초 요청시에 ServerSocket 최초 요청을 받아, 그 클라이언트를 전담할 Socket을 생성
		
		//3. 클라이언트로 부터 접속 요청이 올 때까지 대기
		System.out.println("클라이언트의 요청을 기다리고 있습니다...");
		
		while(true) {
			
			try (	ServerSocket serverSocket = new ServerSocket(port);
					 Socket socket = serverSocket.accept();	 	// 4. 클라이언트의 요청을 기다리고 있다가, 요청이 오면 클라이언트를 전담할 소켓을 생성
					 PrintWriter writer = new PrintWriter(socket.getOutputStream());
					 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); ) {
					
					//5. 연결된 클라이언트의 IP주소 확인
					String clientIP  =  socket.getInetAddress().getHostAddress();
					//System.out.println("client IP : " + clientIP);
					
					String request = br.readLine();
					
					InetAddress local = InetAddress.getLocalHost();
					
					if(clientIP.equals(local.getHostAddress())) {
						if(request.equals("exit")) {
							System.out.println("서버를 종료합니다...");
							break;
						}
					}
					
					System.out.println("client의 요청 : " + request);
					
					writer.println("반가워 나는 서버야~");
					writer.flush();
				
			} catch (IOException e) {
				System.out.println("서버에 문제가 생겼습니다...");
				break;
			}
		}
	}
}
