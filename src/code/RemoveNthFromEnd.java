package code;

import test.ListNode;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node = head;
		int length = 0;
		if (node != null) {
			length = 1;
		} else {
			return null;
		}
		while ((node = node.next) != null) {
			length++;
		}
		node = head;
		length = length - n;
		while (node != null) {
			if (length == 0) {
				node.next = null;
				head = node.next;
				break;
			}
			if (length == 1) {
				if (node.next.next == null) {
					node.next = null;
					break;
				} else {
					node.next = node.next.next;
					break;
				}
			}
			length--;
			node = node.next;
		}
		return head;
	}
}
