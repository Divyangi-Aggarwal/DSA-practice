package com.acts.cq;

public interface CircularQueueImpl<T> {
	void enqueue(T data);
	T dequeue();
	T peek();
	boolean isEmpty();
	boolean isFull();

}
