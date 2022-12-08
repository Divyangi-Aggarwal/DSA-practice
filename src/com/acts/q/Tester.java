package com.acts.q;

import com.acts.s.StackArray;

public class Tester {

	public static void main(String[] args) {
		QueueUsingStack s = new QueueUsingStack();
		System.out.println(s.isEmpty());
		s.enqueue(15);
		s.enqueue(10);
		s.enqueue(25);
		s.enqueue(24);
		s.enqueue(30);
		s.enqueue(40);
		System.out.println(s.isFull());
		System.out.println(s.isEmpty());
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
		System.out.println("Peek "+s.peek());
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
		System.out.println(s.isEmpty());
		System.out.println(s.isFull());
	}

}
