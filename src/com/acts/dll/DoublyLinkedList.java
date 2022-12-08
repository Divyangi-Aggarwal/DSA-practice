package com.acts.dll;
class Node<T>{
	public T data;
	public Node<T> next;
	public Node<T> previous;
	
	
	public Node(T data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}
}

public class DoublyLinkedList<T> implements DoublyLinkedListImpl<T> {
	private Node<T> head;
	private Node<T> tail;
	private static int count=0;
	
	

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	@Override
	public void addFirst(T data) {
		Node<T> node = new Node<T>(data);
		if(isEmpty()) {
			head = node;
			tail=node;
			count++;
			return;
		}
		node.next = head;
		head.previous = node;
		head = node;
		count++;
		
	}

	@Override
	public void addLast(T data) {
		Node<T> node = new Node<T>(data);
		if(isEmpty()) {
			head = node;
			tail=node;
			count++;
			return;
		}
		node.previous = tail;
		tail.next = node;
		tail = node;
		count++;
		
	}

	@Override
	public void insert(T data, T index) {
		Node<T> node = new Node<T>(data);
		int count1 =0;
		if(isEmpty() || (int)index==0) {
			addFirst(data);
		}
		if((int)index == count) {
			addLast(data);
		}
		if((int)index>count) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> current = head;
		while(count1<(int)index) {
			count1++;
			
			if(count1==(int)index) {
				node.previous=current;
				//Node<T> temp = current.next;
				node.next = current.next;
				current.next.previous = node;
				current.next =node;
				count++;
				return;
				
			}
			current = current.next;
		}
		
	}

	@Override
	public T deleteFirst() {
		if(isEmpty()) {
			return null;
		}
		if(head == tail) {
			T data = (T)head.data;
			head = null;
			tail = null;
			count--;
			return data;
		}
		T data = head.data;
		head=head.next;
		head.previous = null;
		count--;
		return data;
	}

	@Override
	public T deleteLast() {
		if(isEmpty()) {
			return null;
		}
		if(head == tail) {
			T data = (T)head.data;
			head = null;
			tail = null;
			count--;
			return data;
			
		}
		T data = tail.data;
		tail=tail.previous;
		tail.next = null;
		count--;
		return data;
	}

	@Override
	public T deleteAtIndex(T index) {
		if(isEmpty() || (int)index==1) {
			deleteFirst();
		}
		if((int)index==count-1) {
			deleteLast();
		}
		if((int)index>count) {
			throw new IndexOutOfBoundsException();
		}
		int count1=0;
		Node<T> current = head;
		while(count1<(int)index) {
			count1++;
			
			if(count1==(int)index) {
				T data = current.next.data;
				current.next.next.previous = current;
				current.next=current.next.next;
				
				count--;
				return data;
				
			}
			current = current.next;
		}
		return null;
	}

	@Override
	public void delete(T data) {
		if(isEmpty()) {
			return;
		}
		while(head.data==data) {
		
				head=head.next;
				count--;
				if(head == null) {
					return;
				}
			head.previous = null;
			
		}
		while(tail.data==data) {
			tail=tail.previous;
			tail.next = null;
			count--;
		}
		Node<T> current = head;
		while(current.next != null) {
			
			if( current.next.data== data) {
				if(current.next.next !=null) {
					current.next.next.previous = current;
					current.next=current.next.next;
					count--;
					continue;
				}
				else {
					current.next=null;
					tail=current;
					count--;
					return;
				}	
			}
			current = current.next;
		}
		
	}

	@Override
	public boolean search(T data) {
		Node<T> current = head;
		while(current != null) {
			if(current.data == data) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public int length() {
		return count;
	}

	@Override
	public int countFrequency(T data) {
		Node<T> current = head;
		int count1 =0;
		while(current != null) {
			if(current.data == data) {
				count1++;
			}
			current = current.next;
		}
		return count1;
	}

	@Override
	public void reverse() {
		Node<T> current1 = head;
		Node<T> current2 = null;
		tail= head;
		
		while(current1 != null) {
			Node temp = current1.next;
			
			current1.next = current2;
			current1.previous=temp;
			current2 = current1;
			current1 = temp;
		
		}
		head=current2;
		
	}

	@Override
	public void print() {
		Node<T> current = head;
		while(current != null) {
			System.out.print(current.data+"->");
			current = current.next;
		}
		System.out.println();
	}

	@Override
	public void reversePrint() {
		Node<T> current = tail;
		while(current != null) {
			System.out.print(current.data+"->");
			current = current.previous;
		}	
		System.out.println();
	}

	@Override
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		return false;
	}

}
