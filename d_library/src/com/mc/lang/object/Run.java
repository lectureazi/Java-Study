package com.mc.lang.object;

public class Run {

	public static void main(String[] args) {
		
		Author author = new Author("김애란", 39, 'F');
		
		Book book1 =  new Book("오빠가 돌아왔다", author, 10000);
		Book book2 =  new Book("오빠가 돌아왔다", author, 10000);
		Book book3 = (Book) book1.clone();
		
		System.out.println(System.identityHashCode(book3));
		System.out.println(System.identityHashCode(book1));
		
		System.out.println(book1);
		System.out.println(book3);
		
		//book1과 book2는 같은 객체일까?
		System.out.println(book1.equals(book2));
		System.out.println(book1.hashCode());
		System.out.println(book2.hashCode());
		
	}
}
