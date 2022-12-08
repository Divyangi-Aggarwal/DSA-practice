package com.acts.cq;

import java.util.Arrays;

public class CircularQueue<T> implements CircularQueueImpl<T>  {
	private int front;
	private int rear;
	private int size;
	private Object[] arr;

	public CircularQueue(int size) {
		super();
		this.front = 0;
		this.rear = 0;
		this.arr = new Object[size];
		this.size=size;
	}

	@Override
	public void enqueue(T data) {
		if(isFull()) {
			return;
		}
		arr[(rear+1)%size] = data;
		rear++;

	}

	@Override
	public T dequeue() {
		if(isEmpty()) {
			return null;
		}
		T data = (T) arr[(front+1)%size];
		arr[(front+1)%size]=null;
		front++;
		return data;
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			return null;
		}

		T data = (T) arr[(front+1)%size];

		return data;
	}

	@Override
	public boolean isEmpty() {
		if(rear == front) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if((rear+1)%size == front) {
			return true;
		}
		return false;
	}

	public String print() {
		StringBuilder sb = new StringBuilder();
		int o=front+1;
		while((o)%size != (rear+1)%size) {
			sb.append(" ");
			sb=sb.append(arr[((o++)%size)]);
			//o++;
		}
		int a = sb.length();
		return sb.substring(0,a);
	}

	@Override
	public String toString() {
		return "CircularQueue [front=" + front + ", rear=" + rear + ", size=" + size + ", arr=" + Arrays.toString(arr)
				+ "]";
	}



}
