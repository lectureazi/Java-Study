package com.mc.qrserver.presentaion;

import com.mc.qrserver.http.HttpHeader;
import com.mc.qrserver.http.HttpRequest;
import com.mc.qrserver.http.HttpResponse;
import com.mc.qrserver.service.QRService;

public class QRContorller {
	
	private QRService qrService = new QRService();
	
	// 클라이언트가 / 로 요청했을 때 Server가 호출해줄 메서드
	// 서버가 전달해준 파라미터를 어플리케이션 내에서 쓰기 용이하도록 파싱
	// 클라이언트에게 보여줄 데이터를 서버에게 전달
	public HttpResponse index(HttpRequest request, HttpResponse httpResponse){
		
		HttpHeader header = new HttpHeader();
		header.data.put("Content-Type", "text/html; Charset=utf-8");
		String body = indexTemplate();
		
		httpResponse.setHeader(header);
		httpResponse.setBody(body);
		return httpResponse;
	}
	
	public HttpResponse qrCode(HttpRequest request, HttpResponse httpResponse) {
		
		String contents = request.getParameters().get("contents");
		String fileName = request.getParameters().get("fileName");
		String color = request.getParameters().get("color");
		
		//서버로 부터 받은 rgb값을 argb값으로 변경
		color = color.substring(1);
		color = "ff" + color;
		int argb = Integer.parseUnsignedInt(color, 16);
		
		HttpHeader header = new HttpHeader();
		header.data.put("Content-Type", "image/jpeg; Charset=utf-8");
		header.data.put("Content-Disposition", "attachment; filename=" + fileName + ".jpg");
		
		httpResponse.setHeader(header);
		
		qrService.createQRCode(contents, argb, httpResponse.getResponseStream());
		return httpResponse;
	}
	
	private String indexTemplate() {
		return "<div style='background-image: "
				+ "		 url(https://img.khan.co.kr/news/2022/11/29/news-p.v1.20221129.94705a5f45094298b265d20ff7563591_Z1.jpg); color:white"
				+ "'>" 
				+ "<h1>QRCode 다운로드 받는 사이트</h1>" 
				+ "<h2>QR코드 원하세요?</h2>" 
				
				+ "<form action='/qrcode'>\n" // get / http/1.1 
					+ "<h4>다운 받을 파일 이름  *************</h4> \n"
					+ "<input type='text' name='fileName' required/> \n"
					+ "<h4>QR코드로 만들 문자열 *************</h4> \n"
					+ "<input type='text' name='contents' required/> \n"
					+ "<h4>QR코드 색상 *************</h4> \n"
					+ "<input type='color' name='color' required/> \n"
					+ "<button>전송</button> \n"
				+ "</form> \n";
	}


	
	
	
	

}
