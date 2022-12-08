package com.acts.q;

public class QueueArray<T> implements QueueImpl<T> {
	private int start;
	private int end;
	private int size;
	private Object[] arr;

	public QueueArray(int size) {
		this.start = -1;
		this.end = -1;
		this.arr = new Object[size];
		this.size = size;
	}

	@Override
	public void enqueue(T data) {
		if(isFull()) {
			return;
		}
		arr[++end]=data;
	}

	@Override
	public T dequeue() {
		if(isEmpty()) {
			return null; 
		}
		T a = (T) arr[++start];
		return a;
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			return null; 
		}
		++start;
		T a = (T) arr[start];
		start--;
		return a;
	}

	@Override
	public boolean isEmpty() {
		if(start==end) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(end==size-1) {
			return true;
		}
		return false;
	}

}
