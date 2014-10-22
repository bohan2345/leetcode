package code;

import test.ListNode;

public class DeduplicateFromListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode node = head;
		ListNode prev = null;
		boolean d = false;
		while (node.next != null) {
			if (node.val == node.next.val) {
				d = true;
				head = remove(node, node.next, head);
				continue;
			} else {
				if (d) {
					d = false;
					head = remove(prev, node, head);
				} else {
					prev = node;
				}
				node = node.next;
			}
		}
		if (d) {
			head = remove(prev, node, head);
		}
		return head;
	}

	ListNode remove(ListNode prev, ListNode node, ListNode head) {
		if (prev == null)
			return head.next;
		prev.next = node.next;
		return head;
	}
}
