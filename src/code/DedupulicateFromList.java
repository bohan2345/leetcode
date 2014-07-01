package code;

import test.ListNode;

public class DedupulicateFromList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode node = head;
		while (node != null && node.next != null) {
			if (node.val == node.next.val) {
				if (node.next.next != null) {
					node.next = node.next.next;
				} else {
					node.next = null;
				}
				continue;
			}
			node = node.next;
		}
		return head;
	}
}
