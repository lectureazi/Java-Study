package com.mc.g_netrwork.b_tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
	
	public void clientStart() {
		
		// 서버의 ip와 port를 지정
		String ip = "10.10.0.17";
		int port = 8989;
		
		while(true) {
			try (Socket socket = new Socket(ip, port);
					 PrintWriter writer = new PrintWriter(socket.getOutputStream());
					 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
					
					 Scanner sc = new Scanner(System.in);
					 String input = sc.nextLine();
					 
					 if(input.equals("client exit")) {
						 System.out.println("client를 종료합니다...");
						 break;
					 }
					 
					 writer.println(input + "\n");
					 writer.flush();
					 System.out.println(br.readLine());

			} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
