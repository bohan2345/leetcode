package code;

import test.ListNode;

public class DedupulicateFromList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode node = head;
		while (node.next != null) {
			if (node.val == node.next.val) {
				head = remove(node, node.next, head);
				continue;
			}
			node = node.next;
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
