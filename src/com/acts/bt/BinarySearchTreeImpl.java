package com.acts.bt;

public interface BinarySearchTreeImpl<T> {

	void insert(T data);
	void delete(T ele);
	boolean search(T ele);
	int height(T ele);
	int numberOfLeafNodes();
	int numberOfNodes();
	void preOrder();
	void postOrder();
	void inOrder();
	void levelOrder();
	void invert();
	T findMin();
	T findMax();
	boolean isEmpty();
	void oddLevel();
	//leftViewOfBinaryTree
	//rightViewOfBinaryTree
	//topViewOfBinaryTree
	//binaryTreeToDoublyLinkedList
	//DiameterOfBinaryTree
	//lowestCommonAncestor
	//burnATree
	//checkForBST
	//twoSumInBst
	//verticalOrderTraversal
}
