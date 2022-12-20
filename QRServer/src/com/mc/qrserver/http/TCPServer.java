package com.mc.qrserver.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.mc.qrserver.presentaion.QRContorller;


// Socket을 사용하 서버와 클라이언트간 연결
// HttpMessage를 프로그램내에서 사용하기 편리한 형태로 가공하여 Controller에게 전달
public class TCPServer {
	
	private ServerSocket serverSocket;
	
	public TCPServer() {
		
		try {
			serverSocket = new ServerSocket(80);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public void startServer() {
	
		System.out.println("서버 시작합니다...");
		
		// connetionless : Http서버는 요청에 대한 응답이 끝나면 통신을 종료(socket을 닫는다) 해준다.
		// stateless 	 : Http서버는 사용자의 이전 상태를 기억하지 않는다.
		//				   클라이언트가 매 요청 자신을 인증할 수 있는 정보를 함께 보낸다.
		while(true) {
			
			// try-with-resources로 인해 매 요청 소켓을 닫아줌
			try(Socket socket = serverSocket.accept()){
				
				BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				String url = parseURL(br);
				
				if(url.equals("/")) {

					QRContorller qrController = new QRContorller();
					HttpResponse response = qrController.index(new HttpRequest(Map.of()), new HttpResponse(bos));
					sendResponse(bos, response);
					
				}else if(url.startsWith("/qrcode")){
					
					QRContorller qrController = new QRContorller();
					Map<String, String> parameter = getParameter(url);
					HttpRequest request = new HttpRequest(parameter);
					HttpResponse response = qrController.qrCode(request,  new HttpResponse(bos));
					
				}else {
					// 존재하지 않는 리소스 요청
					bos.write(HttpStatusCode.NOT_FOUND.getStartLine().getBytes());
					bos.flush();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}

	private void sendResponse(BufferedOutputStream bos, HttpResponse message) throws IOException {
		
		String response = message.getStatus().getStartLine();
		
		for (Entry<String, String> header : message.getHeader().data.entrySet()) {
			response += header.getKey() + ":" + header.getValue() + "\n";
		}
		
		//body와 구분을 위한 공백라인
		response += "\n";
		
		response += message.getBody();
		
		bos.write(response.getBytes());
		bos.flush();
	}

	private String parseURL(BufferedReader br) throws IOException, UnsupportedEncodingException {
		String request = br.readLine();
		request = URLDecoder.decode(request, "utf-8");
		
		//시작줄에서 url만 추출
		String url = request.substring(request.indexOf(" ")+1, request.lastIndexOf(" "));
		return url;
	}

	private Map<String, String> getParameter(String url) {

		String queryString = url.substring(url.indexOf("?")+1);
		Map<String, String> params = new HashMap<String, String>();
		
		for(String param : queryString.split("&")) {
			String[] entry = param.split("=");
			params.put(entry[0], entry[1]);
		}
		
		return params;
	}

	

}
