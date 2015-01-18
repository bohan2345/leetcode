package test;

import code.SortedListToBST;

public class SortedListToBSTtest {
	public static void main(String[] args) {
		SortedListToBST test = new SortedListToBST();
		int[] A = {1,2,3,4};
		ListNode head = LinkedListFactory.createLinkedList(A);
		TreeNode root = test.sortedListToBST(head);
		System.out.println(BinaryTreeUtil.toListLevelOrder(root).toString());
	}
}
