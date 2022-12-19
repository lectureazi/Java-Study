package com.mc.qrserver.http;

public enum HttpStatusCode {
	
	OK(200, "ok", "http/1.1 200 ok\n"),
	NOT_FOUND(404,"Not Found", "http/1.1 404 Not Found\n");
	
	private int code;
	private String message;
	private String startLine;
	
	private HttpStatusCode(int code, String message, String startLine) {
		this.code = code;
		this.message = message;
		this.startLine = startLine;
	}

	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}

	public String getStartLine() {
		return startLine;
	}

	
	
	
	
		
	

}
