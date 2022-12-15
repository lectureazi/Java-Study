package com.mc.exception.test;

import com.mc.exception.custom.TimeOutException;

// 인터페이스끼리는 다중 상속이 가능하다.
public interface Communicatable extends Http, FTP{
	void sendMessage() throws TimeOutException;
	void receiveMessage();
}
