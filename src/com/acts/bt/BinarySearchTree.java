package com.acts.bt;

import com.acts.q.QueueArray;

class Node<T> implements Comparable<T>{
	public T data;
	public Node<T> leftChild;
	public Node<T> rightChild;

	public Node(T data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	@Override
	public int compareTo(T o) {
		int res =0;
		if(o instanceof Integer) {
			Integer o1 =(Integer) this.data;
			Integer o2 =(Integer)o;
			res = o1.compareTo(o2);
		}
		return res;
	}
}

public class BinarySearchTree<T> implements BinarySearchTreeImpl<T> {
	private Node<T> root;
	private int count=0;
	private int count1=0;

	public BinarySearchTree(){
		this.root = null;
	}
	@Override
	public void insert(T data) {
		Node<T> node = new Node<T>(data);
		if(isEmpty()) {
			root=node;
			count++;
			return;
		}
		Node<T> current = root;
		while(current != null) {
			if(current.compareTo(data)==0) {
				return;
			}
			if(current.compareTo(data)<=-1) {
				if(current.rightChild != null) {
					current = current.rightChild;
				}
				else {
					current.rightChild = node;
					count++;
					return;
				}

			}
			if(current.compareTo(data)>=1) {
				if(current.leftChild != null) {
					current = current.leftChild;
				}
				else {
					current.leftChild = node;
					count++;
					return;
				}

			}

		}

	}
	@Override
	public void delete(T ele) {
		deleteImpl(root,ele);
	}


	public void deleteImpl(Node<T> root, T ele) {
		if(isEmpty()) {
			return;
		}
		Node<T> current = root;
		Node<T> previous = null;
		//node has 2 child
		while(current != null) {
			if(current.compareTo(ele)==0) {
				previous= current;
				current= current.rightChild;
				Node<T> next =null;
				while(current != null) {

					if(current.leftChild != null) {
						next = current;
						current = current.leftChild;
					}
					else {
						T temp = current.data;
						current.data= previous.data;
						previous.data = temp;

						previous = next;
						if(current.rightChild != null) {
							previous= current;
							previous.rightChild= null;
							current= null;
							return;
						}
						previous.leftChild= null;
						current= null;
						return;
					}

				}
			}

			if(current.compareTo(ele)<=-1) {
				previous = current;
				current = current.rightChild;
				if(current.compareTo(ele) == 0 && current.leftChild != null && current.rightChild != null) {
					T temp =  current.rightChild.data;
					current.rightChild.data= current.data;
					current.data = temp;
					previous = current;
					current = current.rightChild;


				}
				if(current.compareTo(ele) == 0 && current.rightChild != null) {
					previous.rightChild= current.rightChild;

				}
				if(current.compareTo(ele) == 0 && current.leftChild != null) {
					previous.rightChild = current.leftChild;

				}
				if(current.compareTo(ele) == 0) {
					if(previous.leftChild == current) {
						previous.leftChild = null;
					}
					if(previous.rightChild == current) {
						previous.rightChild = null;
					}

					return;
				}


			}
			if(current.compareTo(ele)>=1) {
				previous = current;
				current = current.leftChild;

				if(current.compareTo(ele) == 0&& current.rightChild != null && current.leftChild != null) {
					T temp = current.rightChild.data;
					current.rightChild.data= current.data;
					current.data = temp;

					previous = current;
					current = current.rightChild;


				}
				if(current.compareTo(ele) == 0 && current.rightChild != null) {

					previous.leftChild= current.rightChild;

				}
				if(current.compareTo(ele) == 0 && current.leftChild != null) {

					previous.leftChild = current.leftChild;

				}
				if(current.compareTo(ele) == 0) {
					if(previous.leftChild == current) {
						previous.leftChild = null;
					}
					if(previous.rightChild == current) {
						previous.rightChild = null;
					}
					return;
				}

			}
		}

	}

	@Override
	public boolean search(T ele) {
		//Node<T> node = new Node<T>(ele);
		if(isEmpty()) {
			return false;
		}
		Node<T> current = root;
		while(current != null) {
			if( current.compareTo(ele) == 0) {
				return true;
			}
			if( current.compareTo(ele) <= -1) {

				current = current.rightChild;

			}
			if( current.compareTo(ele) >= 1) {

				current = current.leftChild;

			}

		}
		return false;
	}

	@Override
	public int height(T ele) {

		if(isEmpty()) {
			return 0;
		}
		Node<T> current = root;
		while(current != null) {
			if( current.compareTo(ele) == 0) {
				return heightImpl(current)-1;
			}
			if( current.compareTo(ele) <= -1) {

				current = current.rightChild;

			}
			if( current.compareTo(ele) >= 1) {

				current = current.leftChild;

			}

		}
		return 0;
	}
	public int heightImpl(Node<T> node) {
		if(node == null) {
			return 0;
		}
		return Math.max(heightImpl(node.leftChild)+1,heightImpl(node.rightChild)+1);
	}


	@Override
	public int numberOfLeafNodes() {
		numberOfLeafNodesImpl(root);
		return count1;
	}
	public void numberOfLeafNodesImpl(Node<T> root) {
		if(root == null) {
			return;
		}
		if(root.leftChild != null) {
			numberOfLeafNodesImpl(root.leftChild);	
		}
		if(root.leftChild == null && root.rightChild==null) {
			count1++;
		}
		if(root.rightChild != null) {
			numberOfLeafNodesImpl(root.rightChild);
		}

	}

	@Override
	public int numberOfNodes() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public void preOrder() {
		preOrderImpl(root);
		System.out.println();

	}
	public void preOrderImpl(Node<T> root) {
		if(root == null) {
			count1++;
			return;
		}
		System.out.print(root.data+"  ");
		if(root.leftChild !=null) {
			preOrderImpl(root.leftChild);
		}
		if(root.rightChild !=null) {
			preOrderImpl(root.rightChild);
		}
	}

	@Override
	public void postOrder() {
		postOrderImpl(root);
		System.out.println();

	}
	public void postOrderImpl(Node<T> root) {
		if(root == null) {
			return;
		}

		if(root.leftChild !=null) {
			postOrderImpl(root.leftChild);
		}
		if(root.rightChild !=null) {
			postOrderImpl(root.rightChild);
		}
		System.out.print(root.data+"  ");
	}

	@Override
	public void inOrder() {

		inOrderImpl(root);
		System.out.println();
	}
	public void inOrderImpl(Node<T> root) {
		if(root == null) {
			return;
		}

		if(root.leftChild !=null) {
			inOrderImpl(root.leftChild);
		}
		System.out.print(root.data+"  ");
		if(root.rightChild !=null) {
			inOrderImpl(root.rightChild);
		}

	}


	@Override
	public void levelOrder() {
		levelOrderImpl(root);

	}
	public void levelOrderImpl(Node<T> root) {
		QueueArray<Node<T>> queue = new QueueArray<>(50);
		Node<T> a = new Node<>(null);
		queue.enqueue(root);
		queue.enqueue(a);
		while(!queue.isEmpty()) {
			root = queue.dequeue();
			if(root.leftChild != null) {
				queue.enqueue(root.leftChild);	
			}
			if(root.rightChild != null) {
				queue.enqueue(root.rightChild);	
			}if(queue.peek()== a) {

				queue.enqueue(a);

			}
			if(root != a) {
				System.out.print(root.data+"  ");
			}else {
				System.out.println();
				if(queue.peek() == a) {
					queue.dequeue();


				}
			}
		}
	}


	@Override
	public void invert() {
		invertImpl(root);

	}
	public void invertImpl(Node<T> root) {
		if(root == null) {
			return;
		}
		Node<T> temp = root.rightChild;
		root.rightChild = root.leftChild;
		root.leftChild = temp;
		if(root.leftChild !=null) {
			invertImpl(root.leftChild);
		}
		if(root.rightChild !=null) {
			invertImpl(root.rightChild);
		}

	}

	@Override
	public T findMin() {
		Node<T> current = root;
		while(current != null) {
			if(current.leftChild != null) {
				current = current.leftChild;
			}
			else {
				return current.data;
			}
		}
		return null;
	}

	@Override
	public T findMax() {
		Node<T> current = root;
		while(current != null) {
			if(current.rightChild != null) {
				current = current.rightChild;
			}
			else {
				return current.data;
			}
		}
		return null;
	}
	@Override
	public boolean isEmpty() {
		if(root == null) {
			return true;
		}
		return false;
	}
	@Override
	public void oddLevel() {
		oddLevelImpl(root);
	}
	public void oddLevelImpl(Node<T> root) {
		if(isEmpty()) {
			return;
		}
		Node<T> temp = new Node<T>(null);
		//Node<T> current = root;
		QueueArray<Node<T>> queue = new QueueArray<>(50);
		queue.enqueue(root.leftChild);
		queue.enqueue(root.rightChild);
		queue.enqueue(temp);
		while(!queue.isEmpty()) {
			root=queue.dequeue();
			if(root.leftChild != null) {
				if(root.leftChild.leftChild != null) {
					queue.enqueue(root.leftChild.leftChild);
				}
				if(root.leftChild.rightChild != null) {
					queue.enqueue(root.leftChild.rightChild);
				}
			}
			if(root.rightChild != null) {
				if(root.rightChild.leftChild != null) {
					queue.enqueue(root.rightChild.leftChild);
				}
				if(root.rightChild.rightChild != null) {
					queue.enqueue(root.rightChild.rightChild);
				}
			}
			
			if(queue.peek() == temp) {
				queue.enqueue(temp);
			}
			if(root != temp) {
				System.out.print(root.data+" ");
			}
			else {
				System.out.println();
				if(queue.peek()==temp) {
					queue.dequeue();
				}
			}
		}
	}

}
