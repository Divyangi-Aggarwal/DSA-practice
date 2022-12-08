package com.acts.dll;

public interface DoublyLinkedListImpl<T> {
	void addFirst(T data);
	void addLast(T data);
	void insert(T data, T index);
	T deleteFirst();
	T deleteLast();
	T deleteAtIndex(T index);
	void delete(T data);
	boolean search(T data);
	int length();
	int countFrequency(T data);
	void reverse();
	void print();
	void reversePrint();
	boolean isEmpty();
	boolean isFull();
}
