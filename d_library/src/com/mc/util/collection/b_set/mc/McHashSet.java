package com.mc.util.collection.b_set.mc;

import java.util.Iterator;

import com.mc.util.collection.a_list.mc.node.Node;

public class McHashSet<E> implements Iterable<E>{
	
	private Node<E>[] table;
	private int capacity = 4;
	private int size;
	
	@SuppressWarnings("unchecked")
	public McHashSet() {
		table = new Node[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public McHashSet(int initialCapacity) {
		this.capacity = initialCapacity;
		table = new Node[capacity];
	}
	
	//해시함수 : 사용자가 넣은 요소를 [0 ~ table의 크기 - 1] 사이의 양의 정수 값으로 변환해주는 해시 함수
	private int hash(E e) {
		// hashCode는 음수도 반환
		// 절대값으로 변경
		int val = Math.abs(e.hashCode());
		val %= capacity;
		
		//System.out.println("해시값은 : " + val);
		return val;
	}
	
	// 데이터 추가 성공유무에 따른 boolean값 반환
	private boolean addData(E e, Node<E>[] table) {
		int idx = hash(e);
		
		// 테이블의 인덱스에 header Node가 존재하지 않으면 무조건 추가
		if(table[idx] == null) {
			table[idx] = new Node<E>(null, null, e);
		}else {
			
			Node<E> tmp = table[idx];
			while(true) {
				//참조되어 있는 Node 중에서 추가하려는 e를 data로 가지고 있는 Node가 있다면 추가하지 않고, false 반환
				if(tmp.getData().equals(e)) return false;
				if(tmp.next() == null) break;
				tmp = tmp.next();
			}
			
			tmp.setNext(new Node<E>(tmp, null, e));
		}
		return true;
	}
	
	public void add(E e) {
		
		if(size < capacity) {
			if(addData(e, table)) size++;
		}else {
			extendsTable();
			if(addData(e, table)) size++;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void extendsTable() {
		capacity *= 2;
		
		Node[] tmpTable = new Node[capacity];
		
		for (int i = 0; i < size; i++) {
			
			//table의 인덱스에 null 이 있는 경우
			if(table[i] == null) continue;
			Node<E> tmp = table[i];
			
			while(true) {
				addData(tmp.getData(), tmpTable);
				if(tmp.next() == null) break;
				tmp = tmp.next();
			}
		}
		
		table = tmpTable;
	}
	
	public Node<E> getNode(E e) {
		
		int index = hash(e);
		Node<E> node = table[index];
		
		if(node == null) return null;
		
		while(true) {
			if(e.equals(node.getData())) return node;
			if(node.next() == null) break;
			node = node.next();
		}
		
		return null;
	}
	
	public boolean remove(E e) {
		
		Node<E> node = getNode(e);
		if(node == null) return false;
		
		if(node.prev() == null) {
			table[hash(e)] = node.next();
			node.next().setPrev(null);
			size--;
			return true;
		}
		
		if(node.next() == null) {
			node.prev().setNext(null);
			size--;
			return true;
		}
		
		node.prev().setNext(node.next());
		node.next().setPrev(node.prev());
		
		size--;
		return true;
	}

	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < size; i++) {
			
			Node<E> tmp = table[i];
			if(tmp == null) continue;
			
			sb.append(tmp + " /// ");
			
			while(tmp.next() != null) {
				sb.append(tmp.next() + " /// ");
				tmp = tmp.next();
			}
		}

		return sb.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			
			Node<E> node = null;
			private int pointer = -1;  // Node[] table에서 탐색한 인덱스
			private int cnt; //반환한 요소의 개수

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return cnt < size;
			}

			@Override
			public E next() {
				if(node == null)searchHeadNode();
				E res = node.getData();
				node = node.next();
				cnt++;
				return res;
			}

			private void searchHeadNode() {
				while(true) {
					pointer++;
					if(table[pointer] != null) {
						node = table[pointer];
						break;
					}
				}
			}
		};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
