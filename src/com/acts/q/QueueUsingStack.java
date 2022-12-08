package com.acts.q;

import com.acts.s.Stack;

public class QueueUsingStack<T> implements QueueImpl<T> {
	Stack<T> s = new Stack<T>();
	@Override
	public void enqueue(T data) {
		if(isFull()) {
			return;
		}
		s.push(data);
		
	}

	@Override
	public T dequeue() {
		if(isEmpty()) {
			return null;
		}
		Stack<T> s1 = new Stack<T>();
		while(!s.isEmpty()) {
			s1.push(s.pop());
		}
		T data=s1.pop();
		while(!s1.isEmpty()) {
			s.push(s1.pop());
		}
		return data;
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		Stack<T> s1 = new Stack<T>();
		while(!s.isEmpty()) {
			s1.push(s.pop());
		}
		T data= s1.peek();
		while(!s1.isEmpty()) {
			s.push(s1.pop());
		}
		return data;
	}

	@Override
	public boolean isEmpty() {
		
		return s.isEmpty();
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return s.isFull();
	}

}
