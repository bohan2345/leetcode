package test;

import code.ReorderList;

public class ReorderListTest {
	public static void main(String[] args) {
		ReorderList test = new ReorderList();
		int[] A = { 1, 2, 3 };
		ListNode head = LinkedListFactory.createLinkedList(A);
		test.reorderList(head);
		System.out.println(LinkedListFactory.toString(head));
		System.out.println(LinkedListFactory.reverse(head).toString());
	}
}
