package com.acts.s;

import com.acts.q.Queue;

public class StackUsingQueue<T> implements StackImpl<T> {
	Queue<T> q = new Queue<T>();
	@Override
	public void push(T data) {
		if(q.isFull()) {
			return;
		}
		Queue<T> q1 = new Queue<T>();
		while(!q.isEmpty()) {
			q1.enqueue(q.dequeue());
		}
		q.enqueue(data);
		
		while(!q1.isEmpty()) {
			q.enqueue(q1.dequeue());
		}
	}

	@Override
	public T pop() {
		if(q.isEmpty()) {
			return null;
		}
		
		return q.dequeue();
	}

	@Override
	public T peek() {
		if(q.isEmpty()) {
			return null;
		}
		
		return q.peek();
	}

	@Override
	public boolean isEmpty() {
	
		return q.isEmpty();
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return q.isFull();
	}

}
