package com.linkedlist;

public class LinkedList<T> {

	Node<T> head;
	Node<T> last;

	public LinkedList() {
		last = new Node<T>(null);
		head = last;
	}

	static class Node<T> {
		T value;
		Node<T> next;

		Node(T value) {
			this.value = value;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}

	}

	public void printList() {
		Node<T> n = this.head.next;
		int c = 0;
		while (n != null) {
			System.out.println("Element at : " + c++ + "  is " + n.value);
			n = n.next;
		}
	}

	public void addNode(Node<T> node) {
		this.last.next = node;
		last = node;
	}

	public int getIndex(int i) {
		return 0;
	}

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.addNode((new Node<String>("First")));
		linkedList.addNode((new Node<String>("Second")));
		linkedList.addNode((new Node<String>("Third")));
		linkedList.printList();
	}

}
