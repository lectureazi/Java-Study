package com.mc.qrserver.exception;

public class NoRequiredPropertyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7538820278899176694L;

	public NoRequiredPropertyException() {
		super("필수적인 속성값이 빠졌습니다.");
	}
	
}
