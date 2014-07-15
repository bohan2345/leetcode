package code;

import java.util.HashSet;
import java.util.Set;

import test.ListNode;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		Set<ListNode> nodes = new HashSet<ListNode>();
		nodes.add(head);
		ListNode node = head;
		while (node.next != null) {
			node = node.next;
			if (nodes.contains(node)) {
				return node;
			} else {
				nodes.add(node);
			}
		}
		return null;
	}

	public ListNode detectCycleII(ListNode head) {
		if (head == null)
			return null;
		ListNode a = head;
		ListNode b = head;
		while (a != null && b != null) {
			a = a.next;
			b = b.next;
			if (b != null)
				b = b.next;
			else
				return null;
			if (a == b)
				break;
		}
		if (b == null)
			return null;
		a = head;
		while (true) {
			if (a == b)
				break;
			a = a.next;
			b = b.next;
		}
		return b;
	}
}
