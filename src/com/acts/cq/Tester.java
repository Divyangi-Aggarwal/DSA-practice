package com.acts.cq;

import com.acts.q.QueueArray;

public class Tester {

	public static void main(String[] args) {
		CircularQueue<String> s = new CircularQueue<>(5);
		System.out.println(s.isEmpty());
		s.enqueue("hello");
		s.enqueue("Hiiii");
		s.enqueue("Bye");
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
		System.out.println(s);
		s.enqueue("hello");
		s.enqueue("Hiiii");
		
		
		System.out.println(s);
	System.out.println(s.print());
	System.out.println(s);
//		System.out.println(s.isFull());
//		
//		System.out.println(s.isFull());
//		System.out.println(s.isEmpty());
//	
//		System.out.println(s.dequeue());
//		System.out.println(s.dequeue());
//		System.out.println("Peek "+s.peek());
//		System.out.println(s.dequeue());
//		System.out.println(s.dequeue());
//		System.out.println(s.dequeue());
//		System.out.println(s.isEmpty());
//		System.out.println(s.isFull());
	}

}
