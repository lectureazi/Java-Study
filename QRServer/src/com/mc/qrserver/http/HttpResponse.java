package com.mc.qrserver.http;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Map.Entry;

public class HttpResponse {
	
	private HttpStatusCode status;
	private HttpHeader header;
	private String body;
	private BufferedOutputStream responseStream;
	
	public HttpResponse(BufferedOutputStream responseStream) {
		super();
		this.status = HttpStatusCode.OK;
		this.responseStream = responseStream;
	}

	public BufferedOutputStream getResponseStream() {
		prepareResponse();
		return responseStream;
	}

	public HttpStatusCode getStatus() {
		return status;
	}
	
	public HttpHeader getHeader() {
		return header;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}

	public void setStatus(HttpStatusCode status) {
		this.status = status;
	}

	public void setHeader(HttpHeader header) {
		this.header = header;
	}

	private void prepareResponse()  {
		String response = status.getStartLine();
		
		for (Entry<String, String> header : header.data.entrySet()) {
			response += header.getKey() + ":" + header.getValue() + "\n";
		}
		
		response += "\n";
		
		try {
			responseStream.write(response.getBytes());
			responseStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendResponse() {
		
		try {
			prepareResponse();
			responseStream.write(body.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
