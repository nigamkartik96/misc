package com.pattern;

import java.util.ArrayList;
import java.util.Stack;

public class NAry {

	public static void main(String[] args) {
		int[] tree = { 1, 2, 1, 3 };
		System.out.println(buildTree(3, tree));
	}

	static class Node {
		int val;
		ArrayList<Node> child;

		Node(int v) {
			this.val = v;
			child = new ArrayList<Node>();
		}

		@Override
		public String toString() {
			return "Node [val=" + val + ", child=" + child + "]";
		}

	}

	public static Node buildTree(int n, int[] ary) {
		Node[] nodes = new Node[16];
		for (int i = 0; i < n; i++)
			nodes[i] = new Node(i);

		for (int i = 0; i < ary.length; i += 2) {
			int u = ary[i] - 1;
			int v = ary[i + 1] - 1;
			nodes[u].child.add(nodes[v]);
		}
		Stack<Integer> s = new Stack<>();
		return nodes[0];
	}

}
