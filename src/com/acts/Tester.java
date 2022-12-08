package com.acts;

public class Tester {

	public static void main(String[] args) {
		SinglyImpl l = new SinglyImpl();
		l.addLast(1);
		l.addLast(2);
		l.addLast(6);
		l.addLast(4);
		l.addLast(6);
		l.addLast(4);
		l.addLast(5);
		l.addLast(2);
		l.addLast(1);
		
		l.print();
		
		System.out.println(palindrom(l));
//
//		SortedLL l1 = new SortedLL();
//
//		System.out.println(l1.isEmpty());
//		l1.insert(4);
//		l1.insert(5);
//		l1.insert(6);
//		l1.insert(8);
//		l1.insert(9);
//		l1.insert(22);
//		l1.insert(17);
//		l1.insert(30);
//		l1.print();
//		NodeA head =merge(l,l1);
//
//		print(head);

		//		l1.addFirst(10);
		//		l1.addFirst(50);
		//		l1.addFirst(40);
		//		l1.addFirst(10);
		//		l1.addFirst(10);
		//		l1.addFirst(30);
		//		l1.addFirst(10);
		//
		//		l1.print();
		//		l1.delete(10);
		//		l1.print();
		//		l1.reverse();
		//		l1.print();

		//		
		//		System.out.println(l.isEmpty());
		//		System.out.println(l.isFull());
		//		l.addFirst(15);
		//		l.addFirst(20);
		//		l.addFirst(25);
		//		l.addLast(10);
		//		l.addLast(25);
		//		l.addLast(2);
		//		l.insert(10,2);
		//		l.insert(1,7);
		//		l.insert(35,0);
		//		l.print();
		//		System.out.println("Search "+l.search(10));
		//		System.out.println(l.countFrequency(10));
		//		System.out.println(l.deleteFirst());
		//		System.out.println(l.deleteLast());
		//		l.print();
		//		System.out.println(l.deleteAtIndex(7));
		//		l.print();
		//		l.delete(10);
		//		l.print();
		//		l.delete(25);
		//		l.print();
		//		l.delete(2);
		//		l.print();
		//		System.out.println("LENGTH "+l.length());

	}
	public static boolean palindrom(SinglyImpl l) {
		int len = l.length();
		Node head2=null;
		int j=0;
		if(len%2 !=0) {
			j=(len/2)+2;
		}
		else {
			j=(len/2)+1;
		}
		int count=0;
		Node current=l.head;
		while(count <j) {
			count++;
			if(count == j-1) {
				head2 = current.next;
				current.next=null;
				break;
			}
			current=current.next;
		}
		//print(head2);
	
		Node head1 = reverse(head2);
		
		
		Node current1=l.head;
		Node current2=head1;
		print(current1);
		print(current2);
		while(current2 != null) {
		
			if(current1.data != current2.data) {
				
				return false;
			}
			current1=current1.next;
			current2 = current2.next;
		}
		
		return true;
	}
	public static Node reverse(Node head2) {
		Node current = head2;
		Node previous = null;
		
		while(current != null) {
			Node temp = current;
			current = current.next;
			temp.next = previous;
			previous= temp;
			
			
		
		}
		head2=previous;
		return head2;

	}
	public static NodeA merge(SortedLL l, SortedLL l1) {
		NodeA current= null;
		NodeA header = null;
		NodeA header1 = null;
		NodeA head1 = l.head;
		NodeA head2 = l1.head;
		NodeA head = null;
		if(head1.data >= head2.data) {
			current = head2;
			header1 = head2;
			head = head2;
			header= head1;
		}
		else {
			current = head1;
			header1 = head1;
			head = head1;
			header = head2;
		}
		while(current != null) {
			if(current.next!= null) {
				if(current.next.data>header.data) {
					header1 = current.next;
					current.next = header;
					header = header1;
				}
			}
			if(current.next== null && header != null) {
				current.next = header;
				return head;
			}
			current = current.next;

		}
		return head;
	}
	public static void print(NodeA head) {
		if(head == null) {
			return;
		}
		NodeA current = head;
		while(current != null) {
			System.out.print(current.data+"->");
			current=current.next;
		}
		System.out.println();
	}
	public static void print(Node head) {
		if(head == null) {
			return;
		}
		Node current = head;
		while(current != null) {
			System.out.print(current.data+"->");
			current=current.next;
		}
		System.out.println();
	}
	

}
