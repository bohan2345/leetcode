package test;

import code.MergeTwoLists;

public class MergeTwoListsTest {
	public static void main(String[] args) {
		int[] x = { 1, 3, 4 };
		int[] y = { 2, 5 };
		ListNode test = new ListNode();
		ListNode node1 = test.createListNodes(x);
		ListNode node2 = test.createListNodes(y);

		MergeTwoLists testmerge = new MergeTwoLists();
		ListNode node = testmerge.mergeTwoLists(node1, node2);
		while (node.next != null) {
			System.out.println(node.val);
			node = node.next;
		}
		System.out.print(node.val);
	}
}
