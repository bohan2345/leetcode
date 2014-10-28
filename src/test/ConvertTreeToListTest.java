package test;

import code.ConvertTreeToList;

public class ConvertTreeToListTest {
	public static void main(String[] args) {
		ConvertTreeToList test = new ConvertTreeToList();
		TreeNode root = new TreeNode(0);
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		root.left = a;
		a.left = b;
		root.right = c;
		c.left = d;
		ListNode head = test.convert(root);
		System.out.println(LinkedListFactory.toString(head));
	}
}
