package com.acts.q;

import com.acts.SinglyImpl;

public class Queue<T> implements QueueImpl<T>{
	SinglyImpl s = new SinglyImpl();
	@Override
	public void enqueue(T data) {
		s.addFirst(data);
		
	}

	@Override
	public T dequeue() {
	
		return (T) s.deleteLast();
	}

	@Override
	public T peek() {
		
		return (T) s.getTail();
	}

	@Override
	public boolean isEmpty() {
		
		return s.isEmpty();
	}

	@Override
	public boolean isFull() {
		
		return s.isFull();
	}
	
}
