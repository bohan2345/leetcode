package test;

import code.ReverseLinkedList;

public class ReverseLinkedLIstTest {
	public static void main(String[] args) {
		ReverseLinkedList test = new ReverseLinkedList();
		int[] A = { 3, 5 };
		ListNode head = (new ListNode()).createListNodes(A);
		head = test.reverseBetween(head, 1, 2);
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
	}
}
