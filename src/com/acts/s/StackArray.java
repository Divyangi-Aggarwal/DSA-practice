package com.acts.s;

public class StackArray<T> implements StackImpl<T> {
	 	private int top;
	 	private int size;
	 	private Object []arr;
	 	
	public StackArray(int size) {
			super();
			this.top = -1;
			this.arr = new Object[size];
			this.size = size;
		}

	@Override
	public void push(T data) {
		if(isFull()) {
			return;
		}
		arr[++top]= data;
	}

	@Override
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		T a= (T) arr[top--];
		return a;
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		T a= (T) arr[top];
		return a;
	}
	@Override
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(top==size-1) {
			return true;
		}
		return false;
	}

}
