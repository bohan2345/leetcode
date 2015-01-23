package test;

import code.BinarySearchTree;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree test = new BinarySearchTree();
		test.add(5);
		test.add(3);
		test.add(6);
		test.add(1);
		test.add(4);
		test.add(7);
		test.add(2);
		TreeNode node = test.find(5);
		test.delete(1);
		TreeNode min = test.getMin(node);
		System.out.println(min.val);
	}
}
