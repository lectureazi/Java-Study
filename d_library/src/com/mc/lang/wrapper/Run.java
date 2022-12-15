package com.mc.lang.wrapper;

public class Run {

	public static void main(String[] args) {
		WrapperClass wc = new WrapperClass();
		wc.printTypeSize();
		
		Test test = new Test();
		System.out.println(test);
		
		wc.parse();
	}

}
