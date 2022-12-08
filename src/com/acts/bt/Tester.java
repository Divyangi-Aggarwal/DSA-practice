package com.acts.bt;

public class Tester {

	public static void main(String[] args) {
		BinarySearchTree bt = new BinarySearchTree();
		bt.insert(10);
		bt.insert(6);
		bt.insert(7);
		bt.insert(8);
		bt.insert(1);
		bt.insert(0);
		bt.insert(4);
		bt.insert(15);
		bt.insert(12);
		bt.inOrder();
		//System.out.println();
//		bt.postOrder();
//		//System.out.println();
//		bt.preOrder();
//		//System.out.println();
//		System.out.println(bt.findMax());
//		System.out.println(bt.findMin());
		
		bt.oddLevel();
		bt.levelOrder();
//		System.out.println(bt.search(0));
	//	System.out.println(bt.height(4));
//		System.out.println(bt.numberOfNodes());
//		System.out.println(bt.numberOfLeafNodes()); 
		

	}

}
