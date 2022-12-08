package com.acts.dll;

public class Tester {

	public static void main(String[] args) {
		DoublyLinkedList d = new DoublyLinkedList();
//		d.addFirst(7);
//		d.addFirst(7);
//		d.addLast(7);
//	d.print();
//	//d.deleteFirst();
//	d.insert(6,2);
//	d.print();
//	d.delete(7);
//	d.print();
//	System.out.println(d.length());
//	d.reversePrint();
//	d.reverse();
//	d.print();
		d.addLast(1);
		d.addLast(2);
		d.addLast(3);
		d.addLast(4);
		d.addLast(5);
		d.addLast(6);
		d.addLast(7);
		d.print();
		d.reverse();
		//d.delete(7);
		d.print();
		System.out.println(d.countFrequency(7));
		System.out.println(d.length());
	}

}
