package com.mc.qrserver.http;

import java.util.Map;

public class HttpRequest {
	
	private Map<String, String> parameters;
	
	public HttpRequest(Map<String, String> parameters) {
		super();
		this.parameters = parameters;
	}
	
	public Map<String, String> getParameters() {
		return parameters;
	}
	
	
	
	

}
