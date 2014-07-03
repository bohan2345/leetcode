package code;

import test.ListNode;

public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode node1 = l1, node2 = l2;
		ListNode lastNode = new ListNode(0);
		while (node1 != null && node2 != null) {
			if (node1.val > node2.val) {
				lastNode.next = node2;
				lastNode = node2;
				if (node2.next != null) {
					node2 = node2.next;
				} else {
					node2.next = node1;
					break;
				}
			} else {
				lastNode.next = node1;
				lastNode = node1;
				if (node1.next != null) {
					node1 = node1.next;
				} else {
					node1.next = node2;
					break;
				}
			}
		}
		return (l1.val > l2.val) ? l2 : l1;
	}
}
