package code;

import test.ListNode;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// ListNode node = head;
		// int length = 0;
		// if (node != null) {
		// length = 1;
		// } else {
		// return null;
		// }
		// while ((node = node.next) != null) {
		// length++;
		// }
		// node = head;
		// length = length - n;
		// while (node != null) {
		// if (length == 0) {
		// node.next = null;
		// head = node.next;
		// break;
		// }
		// if (length == 1) {
		// if (node.next.next == null) {
		// node.next = null;
		// break;
		// } else {
		// node.next = node.next.next;
		// break;
		// }
		// }
		// length--;
		// node = node.next;
		// }
		// return head;
		if (head == null)
			return null;
		ListNode node = head;
		int l = n;
		while (node != null) {
			node = node.next;
			l--;
			if (l == 0) {
				break;
			}
		}
		if (node == null) {
			return head.next;
		}
		ListNode node2 = head;

		while (node != null) {
			if (node.next == null) {
				if (node2.next == node) {
					node2.next = null;
				} else
					node2.next = node2.next.next;
			}
			node = node.next;
			node2 = node2.next;
		}
		return head;
	}
}
