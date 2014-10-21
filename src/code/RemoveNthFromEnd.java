package code;

import test.ListNode;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode node = head;
		int length = 0;
		while (node != null) {
			node = node.next;
			length++;
		}
		int index = length - n;
		if (index == 0) {
			return head.next;
		}
		node = head;
		ListNode prev = null;
		while (index > 0) {
			index--;
			prev = node;
			node = node.next;
		}
		prev.next = node.next;
		return head;
	}
}
