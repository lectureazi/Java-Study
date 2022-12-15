package com.mc.util.collection.a_list.mc;

import java.util.Iterator;

import com.mc.util.collection.a_list.mc.node.Node;

public class McLinkedList<E> implements Iterable<E>{
	
	private Node<E> head;  //첫 노드를 저장
	private int size;
	
	public McLinkedList() {}
	
	public int size() {
		return size;
	}
	
	public void add(E e) {
		
		Node<E> tmp = head; //노드 이동용 레퍼런스
		
		if(size == 0) {
			head = new Node<E>(null, null, e);
			size++;
			return;
		}
		
		if(size == 1) tmp = head;
		if(size > 1) tmp = head.prev();
		
		//찾은 마지막 노드의 다음 노드로 새로운 노드를 추가
		//새로운 노드의 이전 노드로 찾은 마지막 노드를 지정
		
		Node<E> newNode = new Node<E>(tmp, head, e);
		tmp.setNext(newNode);
		head.setPrev(newNode);
		size++;
	}
	
	public E get(int index) {
		return getNode(index).getData();
	}
	
	private Node<E> getNode(int index){
		
		if(index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException("크기가 " + size + "입니다.");
		
		Node<E> tmp = head;
		
		if(index < (size - index)) {
			//index 위치의 노드를 tmp 에 참조
			for (int i = 0; i < index; i++) {
				tmp = tmp.next();
			}
		}else {
			//index 위치의 노드를 tmp 에 참조
			for (int i = size; i > index; i--) {
				tmp = tmp.prev();
			}
		}
		
		return tmp;
	}
	
	public E set(int index, E element) {
		
		E res = null;
		Node<E> tmp = getNode(index);
		
		res = tmp.getData();
		tmp.setData(element);
		return res;
	}
	
	public E remove(int index) {
		
		Node<E> tmp = head;
		E res = null;
		
		//첫 노드 일 때
		if(index == 0) {
			head = head.next();
			head.setPrev(null);
			res = tmp.getData();
			size--;
			return res;
		}
		
		//마지막 노드일 때
		if(index == size-1) {
			tmp = getNode(index);
			tmp.prev().setNext(tmp.next());
			res = tmp.getData();
			size--;
			return res;
		}
		
		tmp = getNode(index);
		tmp.prev().setNext(tmp.next());
		tmp.next().setPrev(tmp.prev());
		
		res = tmp.getData();
		size--;
		return res;
	}

	@Override
	public String toString() {
		Node<E> tmp = head;
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < size; i++) {
			sb.append(tmp.getData().toString());
			sb.append(" //// ");
			tmp = tmp.next();
		}
		
		return sb.toString();
	}

	@Override
	public Iterator<E> iterator() {
		
		return new Iterator<E>() {
			//Iterator가 반환한 요소의 개수
			private int iterIdx;
			
			@Override
			public boolean hasNext() {
				return iterIdx < size;
			}

			@Override
			public E next() {
				E res = get(iterIdx);
				iterIdx++;
				return res;
			}
		};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
