package com.mc.i_interface;

// 인터페이스끼리는 다중 상속이 가능하다.
public interface Communicatable extends Http, FTP{
	void sendMessage();
	void receiveMessage();
}
