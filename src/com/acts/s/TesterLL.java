package com.acts.s;

public class TesterLL {

	public static void main(String[] args) {
		StackUsingQueue s = new StackUsingQueue();
		System.out.println(s.isEmpty());
		s.push(15);
		s.push(10);
		s.push(25);
		s.push(24);
		s.push(30);
		s.push(40);
		System.out.println(s.isFull());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println("Peek "+s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.isFull());
	}

}
