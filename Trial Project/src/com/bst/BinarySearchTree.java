package com.bst;

public class BinarySearchTree {

	Node root;

	public BinarySearchTree() {
		root = null;
	}

	static class Node {
		int value;
		Node leftChild;
		Node rightChild;

		public Node(int value) {
			super();
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
		}

	}

	public void add(Node node) {
		if (this.root == null) {
			root = node;
		} else {
			insertNode(node, this.root);
		}
	}

	public void insertNode(Node node, Node currentNode) {
		// Node currentNode = this.root;
		if (node.value > currentNode.value) {
			if (currentNode.rightChild == null) {
				currentNode.rightChild = node;
			} else {
				insertNode(node, currentNode.rightChild);
			}
		} else {
			if (currentNode.leftChild == null) {
				currentNode.leftChild = node;
			} else {
				insertNode(node, currentNode.leftChild);
			}
		}
	}

	public Node get(int value) {
		if (this.root == null) {
			return null;
		}
		return contains(value, this.root);
	}

	public Node contains(int value, Node currentNode) {
		if (value == currentNode.value) {
			System.out.println("Matched");
			return currentNode;
		} else if (currentNode.value > value && currentNode.leftChild != null) {
			return contains(value, currentNode.leftChild);
		} else if (currentNode.value < value && currentNode.rightChild != null) {
			return contains(value, currentNode.rightChild);
		}
		return null;
	}

	public Node delete(int value) {
		if (this.root == null) {
			throw new NullPointerException();
		}

		Node nodeToDelete = contains(value, this.root);
		if (nodeToDelete == null) {
			return null;
		}
		Node parentNode = parent(nodeToDelete, this.root);
		if (parentNode == null) {
			this.root = null;
		} else if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
			if (parentNode.leftChild.value == nodeToDelete.value) {
				parentNode.leftChild = null;
			} else {
				parentNode.rightChild = null;
			}
		} else if (nodeToDelete.leftChild != null && nodeToDelete.rightChild == null
				&& parentNode.leftChild.value == nodeToDelete.value) {
			parentNode.leftChild = nodeToDelete.leftChild;
		} else if (nodeToDelete.rightChild != null && nodeToDelete.leftChild != null
				&& parentNode.rightChild.value == nodeToDelete.value) {
			parentNode.rightChild = nodeToDelete.rightChild;
		} else if (nodeToDelete.rightChild != null && nodeToDelete.leftChild != null) {
			if (nodeToDelete.value == parentNode.leftChild.value) {
				Node max = findMaximum(nodeToDelete);
				parentNode.rightChild.value = max.value;
				parent(max, this.root).rightChild = null;
			} else {
				Node min = findMaximum(nodeToDelete);
				nodeToDelete.value = min.value;
				parent(min, this.root).leftChild.rightChild = null;
			}
		}
		nodeToDelete.leftChild = nodeToDelete.rightChild = null;
		return nodeToDelete;
	}

	public Node findMinimum(Node node) {
		if (node.leftChild == null) {
			return node;
		} else {
			return findMinimum(node.leftChild);
		}
	}

	public Node findMaximum(Node node) {
		if (node.rightChild == null) {
			return node;
		} else {
			return findMaximum(node.rightChild);
		}
	}

	public Node parent(Node node, Node root) {
		if (node.value == root.value) {
			return null;
		}

		if (root.value > node.value) {
			if (root.leftChild == null) {
				return null;
			} else if (root.leftChild.value == node.value) {
				return root;
			} else {
				return parent(node, root.leftChild);
			}
		} else {
			if (root.rightChild == null) {
				return null;
			} else if (root.rightChild.value == node.value) {
				return root;
			} else {
				return parent(node, root.rightChild);
			}
		}
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.leftChild);
			System.out.print(root.value + " ");
			inorder(root.rightChild);
		}
	}

	public void preorder(Node root) {
		if (root != null) {
			System.out.print(root.value + " ");
			preorder(root.leftChild);
			preorder(root.rightChild);
		}
	}

	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.add(new Node(100));
		bst.add(new Node(20));
		bst.add(new Node(18));
		bst.add(new Node(22));
		bst.add(new Node(21));
		bst.add(new Node(23));
		bst.add(new Node(102));
		bst.add(new Node(101));
		bst.add(new Node(103));

		System.out.println("Inorder : ");
		bst.inorder(bst.root);
		System.out.println("\nPreorder : ");
		bst.preorder(bst.root);
		/*
		 * System.out.println(bst.delete(103)); System.out.println(bst.delete(20));
		 * System.out.println(bst.root);
		 */
	}
}
