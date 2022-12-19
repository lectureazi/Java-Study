package com.mc.qrserver;

import com.mc.qrserver.http.TCPServer;

public class Run {

	public static void main(String[] args) {
		new TCPServer().startServer();
	}

}
