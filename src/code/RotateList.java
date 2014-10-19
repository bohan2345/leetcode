package code;

import test.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		int length = 0;
		ListNode node = head;
		ListNode end = head;
		while (node != null) {
			length++;
			if (node.next == null) {
				end = node;
			}
			node = node.next;
		}
		if (length < 2) {
			return head;
		}
		node = head;
		int count = length - n % length;
		ListNode newEnd = end;
		while (count > 0) {
			if (count == 1) {
				newEnd = node;
			}
			node = node.next;
			count--;
		}
		end.next = head;
		newEnd.next = null;
		if (node == null)
			return head;
		else
			return node;
	}
}
