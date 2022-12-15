package com.mc.util.collection.a_list.mc;

import java.util.Arrays;
import java.util.Iterator;

//Generic : 클래스 내부에서 사용할 타입을 외부에서 결정하는 것.
//			클래스가 인스턴스화 되는 시점에 타입이 결정
//			클래스명 뒤에 <E> 와 같은 형태로 Generic을 지정할 수 있다.
//			Generic은 어떤 알파벳이든 사용할 수 있지만, 주로 아래의 알파벳이 많이 사용된다.
//			Generic은 한 클래스 내에서 여러 개 지정이 가능
//			Generic에 지정할 타입에 제한을 걸 수 있다.
//				<? extends List> : List의 후손 타입만 Generic으로 지정 가능
//				<? super List>	 : List의 선조 타입만 Generic으로 지정 가능

// E : element, 배열 기반 구조에서 element의 타입을 결정하는 제네릭일 때 e
// T : Type
// K : Map에서 key의 타입을 generic으로 지정할 때 사용
// V : Map에서 value의 타입을 generic으로 지정할 때 사용

public class McList<E> implements Iterable<E>{
	
	//데이터를 저장할 Object배열
	private Object[] elementData;
	
	//elementData의 크기
	private int capacity = 10;
	
	//elementData에 저장된 요소의 개수
	private int size;
	
	public McList() {
		elementData = new Object[capacity];
	}
	
	public McList(int initialCapacity) {
		this.capacity = initialCapacity;
		elementData = new Object[capacity];
	}
	
	//1. int size()
	//   리스트의 크기를 반환
	public int size() {
		return size;
	}
	
	//2. void add(E e)
	public void add(E e) {
		
		// elementData에 더이상 요소를 추가할 공간이 있는 경우
		if(capacity > size) {
			elementData[size] = e;
			size++;
			return;
		}
				
		// elementData에 더이상 요소를 추가할 공간이 없는 경우
		
		// 기존 elementData 보다 2배 큰 새로운 배열을 생성
		capacity *= 2;
		Object[] temp = new Object[capacity];
		
		// 새로운 배열에 기존 elementData 의 요소들을 옮겨 담는다.
		for (int i = 0; i < elementData.length; i++) {
			temp[i] = elementData[i];
		}
		
		// 매개변수로 전달받은 요소를 새로운 배열에 추가한다.
		temp[size] = e;
		elementData = temp;
		size++;
	}
	
	
	//3. E get(int index)
	@SuppressWarnings("unchecked")
	public E get(int index) {
		
		if(index >= size || index < 0) throw new ArrayIndexOutOfBoundsException("크기가 " + size + "입니다.");
		
		//E 가 미정인데, elementData의 요소가 E로 다운캐스팅 가능한지 어떻게 알지?
		return (E)elementData[index];
	}
	
	
	//4. E set(int index, E element)
	//   지정된 인덱스에 위치한 요소를 지정된 요소로 변경하고,
	//	 변경 되기 전 요소를 반환
	public E set(int index, E element) {
		E res = this.get(index);
		elementData[index] = element;
		return res;
	}
	
	//5. E remove(int index)
	//	 지정된 인덱스에 위치한 요소를 삭제하고
	//	 삭제 된 요소를 반환
	public E remove(int index) {
		
		E res = this.get(index);
		
		// 길이가 10인 elementData에 1,2,3,4 값을 추가할 경우
		// {1,2,3,4, null,null,null,null,null,null}
		// {1,3,4,null,null, null,null,null,null,null,null}
		for (int i = index; i < size; i++) {
			elementData[i] = elementData[i+1];
		}
		
		size--;
		return res;
	}

	@Override
	public String toString() {
		Object[] temp = new Object[size];
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = elementData[i];
		}

		return Arrays.toString(temp);
	}

	@Override
	public Iterator<E> iterator() {
		
		//익명클래스
		//익명클래스 작성 후 익명클래스의 인스턴스를 생성
		//인스턴스를 단발성으로 생성하는 경우라면 익명클래스를 사용해 코드를 작성 할 수도 있다.
		//작성법 new 구현,상속 받을 타입(){}
		return new Iterator<E>() {

			//Iterator가 읽은 데이터의 개수
			private int pointer;

			@Override
			public boolean hasNext() {
				//System.out.println("현재 포인터의 위치: " + pointer );
				return pointer < size;
			}

			@SuppressWarnings("unchecked")
			@Override
			public E next() {
				E res = (E) elementData[pointer];
				//System.out.println("반환할 값 : " + res);
				pointer++;
				return res;
			}
		};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//iterator 메서드가 반환할 Iterator instance 생성을 위한 내부 클래스
	//외부클래스(list) generic 타입을 공유하기 위해 내부클래스로 생성
	public class McIterator implements Iterator<E>{
		
		//Iterator가 읽은 데이터의 개수
		private int pointer;

		@Override
		public boolean hasNext() {
			//System.out.println("현재 포인터의 위치: " + pointer );
			return pointer < size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			E res = (E) elementData[pointer];
			//System.out.println("반환할 값 : " + res);
			pointer++;
			return res;
		}
	}
	
	
	
	
	
	
	
	

}
