package com.mc.j_inner;

public class MissingRequiredPropertyException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7439503237182248271L;

	public MissingRequiredPropertyException() {
		super("반드시 필요한 속성 중 누락된 속성이 존재합니다.");
	}
	
	public MissingRequiredPropertyException(String msg) {
		super(msg);
	}

}
