package com.acts.s;

public interface StackImpl<T> {
	void push(T data);
	T pop();
	T peek();
	boolean isEmpty();
	boolean isFull();
}
