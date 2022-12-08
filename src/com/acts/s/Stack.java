package com.acts.s;



import com.acts.SinglyImpl;

public class Stack<T> implements StackImpl<T>{
	
	SinglyImpl s = new SinglyImpl();
	@Override
	public void push(T data) {
		s.addLast(data);
		
	}

	@Override
	public T pop() {
		
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
		// TODO Auto-generated method stub
		return s.isFull();
	}

}
