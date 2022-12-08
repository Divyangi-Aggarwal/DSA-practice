package com.acts.q;

public interface QueueImpl<T>{
	void enqueue(T data);
	T dequeue();
	T peek();
	boolean isEmpty();
	boolean isFull();
}
