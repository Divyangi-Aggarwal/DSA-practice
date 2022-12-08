package com.acts.cdll;
class Node{
	public int data;
	public Node next;
	public Node pre;
	
	public Node(int data) {

		this.data = data;
		this.next = null;
		this.pre = null;
	}
	
}

public class CircularDLL implements CirculDLLImpl {
	Node head;
	
	
	public CircularDLL() {
		this.head = new Node(-99);
		head.next = head;
		head.pre = head;
	}

	@Override
	public void insert(int ele) {
		Node node = new Node(ele);
		if(isEmpty()) {
			head.next=node;
			head.pre = node;
			node.next = head;
			node.pre = head;
			return;
		}
		Node current = head.next;
		
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reversePrint() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		if(head.next == head && head.pre == head) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

}
