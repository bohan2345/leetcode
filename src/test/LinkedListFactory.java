package test;

public class LinkedListFactory {
	public static ListNode createLinkedList(int[] x) {
		ListNode lastnode = new ListNode(x[0]);
		ListNode head = lastnode;
		for (int i = 1; i < x.length; i++) {
			ListNode node = new ListNode(x[i]);
			lastnode.next = node;
			lastnode = lastnode.next;
		}
		return head;
	}

	public static String toString(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val + ", ");
			head = head.next;
		}
		return sb.toString();
	}
}
