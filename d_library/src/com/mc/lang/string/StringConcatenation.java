package com.mc.lang.string;


// String은 생성된 이후 값을 변경할 수 없는 불변(immutable)객체이다.
// String a = "a";  a+="B";  "aB"
// String을 결합하여 수정할 경우, 해당 인스턴스에 값이 변경되는 것이 아니라 새로운 인스턴스를 생성한다.
public class StringConcatenation {
	
	public void testConcat() {
		//heap 영역에 String constant pool 에 "JAVA" 라는 값을 가지는 객체 생성
		String java = "JAVA";
		String java2 = "JAVA";
		
		System.out.println("수정 전 주소 : " + System.identityHashCode(java));
		System.out.println("리터럴 JAVA 주소 : " + System.identityHashCode("JAVA"));
		System.out.println("java2 주소 : " + System.identityHashCode(java2));
		
		//같은 값의 문자열을 리터럴로 생성할 경우 등위비교연산자를 사용하면 true가 나온다.
		//리터럴로 생성할 경우 같은 값이면, 같은 객체이기 때문!
		System.out.println("java == java2 :" + (java == java2));
		
		//생성자를 사용해 String을 생성할 경우, String Constant pool 대신 일반적인 heap영역에 생성된다.
		//String constant pool을 사용해 얻을 수 있는 메모리상 이점이 사라지게 된다.
		String java3 = new String("JAVA");
		System.out.println("java == java3 :" + (java == java3));
		
//		String test = "The implementation of the string concatenation operator is left to the discretion of a Java compiler, as long as the compiler ultimately conforms to The Java™ Language Specification. For example, the javac compiler may implement the operator with StringBuffer, StringBuilder, or java.lang.invoke.StringConcatFactory depending on the JDK version. The implementation of string conversion is typically through the method toString, defined by Object and inherited by all classes in Java.";
//		
//		while(true) {
//			test += test;
//		}
		
		java += "C";
		System.out.println();
		System.out.println("수정 후 주소 : " + System.identityHashCode(java));
	}
	
	// StringBuilder : 문자열 값을 수정하는 mutable 객체
	// thread 동기화를 지원하지 않는다.
	public void concatWithStringBuilder() {
		StringBuilder builder = new StringBuilder("ABC");
		System.out.println("결합 전 : " + System.identityHashCode(builder));
		
		builder.append("D");
		System.out.println(builder);
		System.out.println("결합 후 : " + System.identityHashCode(builder));
		
		String res = builder.toString();
		System.out.println(res);
	}
	
	// StringBuffer : 문자열 값을 수정하는 mutable 객체
	// thread 동기화를 지원한다.
	public void concatWithStringBuffer() {
		StringBuffer builder = new StringBuffer("ABC");
		System.out.println("결합 전 : " + System.identityHashCode(builder));
		System.out.println(builder);
		
		builder.append("D");
		System.out.println("결합 후 : " + System.identityHashCode(builder));
		System.out.println(builder);
		
		String res = builder.toString();
		System.out.println(res);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
