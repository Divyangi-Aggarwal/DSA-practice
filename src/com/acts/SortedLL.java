package com.acts;
class NodeA{
	public int data;
	public NodeA next;
	
	
	public NodeA(int data) {
		this.data = data;
		this.next = null;
	}
	
}
public class SortedLL {
	NodeA head;

	public SortedLL() {
		this.head = null;
	}
	
	
	public void insert(int data) {
		NodeA node = new NodeA(data);
		if(isEmpty()) {
			head = node;
			return;
		}
		if(head.data> data) {
			node.next = head;
			head = node;
			return;
		}
		NodeA current = head;
		while(current != null) {
			if(current.next != null) {
				if(current.next.data>=data) {
					node.next = current.next;
					current.next = node;
					return;
				}	
			}
			if(current.next==null) {
				current.next = node;
				return;
			}
			current = current.next;
		}
	}
	public void delete(int data) {
		
		if(isEmpty()) {
			
			return ;
		}
		if(head.data== data) {
	
			if(head.next!= null) {
				head = head.next;
			}
			else {
				head= null;
			}
		
			return ;
		}
		NodeA current = head;
		while(current != null) {
			if(current.next != null) {
				if(current.next.data==data) {
					
					current.next = current.next.next;
					continue;
				}	
			}
			
			current = current.next;
		}
		return ;
	}
	
	public void print() {
		if(isEmpty()) {
			return;
		}
		NodeA current = head;
		while(current != null) {
			System.out.print(current.data+"->");
			current=current.next;
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		if(head== null) {
			return true;
		}
		return false;
	}
	public boolean isFull() {
		return false;
	}
	
}
