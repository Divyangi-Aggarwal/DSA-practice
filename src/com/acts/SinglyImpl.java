package com.acts;


class Node<T> {
	public Object data;
	public Node<T> next;

	public Node(T data) {
		this.data=(Object) data;
		this.next = null;

	}
}

public class SinglyImpl<T> implements SinglyLinkedList<T>{
	public Node<T> head;
	private Node<T> tail;
	private int count;

	public SinglyImpl() {
		this.head = null;
		this.tail = null;
		this.count =0;
	}

	
	public T getHead() {
		return (T)head.data;
	}


	public void setHead(Node<T> head) {
		this.head = head;
	}


	public T getTail() {
		return (T)tail.data;
	}


	public void setTail(Node<T> tail) {
		this.tail = tail;
	}


	@Override
	public void addFirst(T data) {
		Node<T> node = new Node<T>(data);

		if(isEmpty()) {
			head = node;
			tail = node;
			count++;
			return;
		}
		node.next = head;
		head = node;
		count++;
		return;


	}

	@Override
	public void addLast(T data) {
		Node<T> node = new Node<T>(data);

		if(isEmpty()) {
			head = node;
			tail = node;
			count++;
			return;
		}
		tail.next = node;
		tail = node;
		count++;
		return;



	}

	@Override
	public void insert(T data, T index) {
		Node<T> node = new Node<T>(data);
		Node<T> current = head;
		int count1 =0;
		if((int)index>count) {
			throw new IndexOutOfBoundsException();
		}
		if((int)index==0) {
			node.next = head;
			head = node;
			count++;
			return;
		}
		while(count1 < (int)index) {
			count1++;
			if(count1==count) {
				Node<T> temp =current.next;
				current.next =node;
				node.next = temp;
				tail=node;
				count++;
				return;
			}
			if(count1 == (int)index) {
				Node<T> temp =current.next;
				current.next =node;
				node.next = temp;
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
		if(head==tail) {
			Node node = head;
			head =null;
			tail=null;
			count--;
			return (T) node.data;
		}
		Node<T> node;
		node=head;
		head=head.next;
		count--;
		return (T) node.data;
	}

	@Override
	public T deleteLast() {
		if(isEmpty()) {
			return null;	
		}
		if(head==tail) {
			Node node = head;
			head =null;
			tail=null;
			count--;
			return (T) node.data;
		}
		Node<T> current = head;
		while(current.next != tail) {
			current = current.next;
		}
		Node node= tail;
		current.next = null;
		tail=current;
		count--;
		return (T) node.data;
	}

	@Override
	public T deleteAtIndex(T index) {
		Node node;
		int count1 =0;
		if((int)index == 0) {
			return deleteFirst();
		}
		if((int)index==count-1) {
			return deleteLast();
		}
		if((int)index>=count) {
			return null;
		}
		Node current = head;
		while(count1<(int)index) {
			count1++;
			
			if(count1==(int)index) {
				node=current.next;
				current.next= node.next;
				count--;
				return (T) node.data;
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
		while(head.data == data) {
			head = head.next;
			count--;
		}
		if(head==tail && head.data == data) {
		 head = null;
		 tail = null;
		 count--;
		 return;
		}
		
		
		
		Node current = head;
		System.out.println(head.data);
		while(current.next != null) {
			if(current.next.data==data) {
				if(current.next.next !=null) {
					current.next = current.next.next;
					count--;
					continue;
				}
				else {
					current.next=null;
					tail = current;
					count--;
					return;
				}
			}
			current = current.next;
		}
		
		return ;
	}

	@Override
	public boolean search(T data) {
		Node current = head;
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
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public int countFrequency(T data) {
		Node current = head;
		int count1=0;
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
		Node current = head;
		Node previous = null;
		if(isEmpty()) {
			return;
		}
		tail=head;
		while(current != null) {
			Node temp = current;
			current = current.next;
			temp.next = previous;
			previous= temp;
			
			
		
		}
		head=previous;
		

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
	public boolean isEmpty() {
		if(head == null && tail == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		
		return false;
	}


}
