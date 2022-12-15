package com.mc.exception.test;

import com.mc.exception.custom.TimeOutException;

public class Run {

	public static void main(String[] args) {
		
		SmartPhone phone = new SmartPhone();
		//phone.setPrica(-10);
		
		try {
			phone.sendMessage();
		} catch (TimeOutException e) {
			e.printStackTrace();
		}
		
	}
}
