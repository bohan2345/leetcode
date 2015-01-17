package code;

import test.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null)
			return null;
		int length = 0;
		ListNode node = head;
		ListNode end = null;
		while (node != null) {
			end = node;
			node = node.next;
			length++;
		}
		n = n % length;
		if (n == 0)
			return head;
		node = head;
		for (int i = 1; i < length - n; i++) {
			node = node.next;
		}
		ListNode newHead = node.next;
		node.next = null;
		end.next = head;
		return newHead;
	}

	public ListNode rotateRightII(ListNode head, int n) {
		int length = 0;
		ListNode newHead = null, prevNewHead = null, end = null;
		for (ListNode node = head; node != null; node = node.next) {
			if (node.next == null) {
				end = node;
			}
			length++;
		}
		if (length < 2 || n == 0 || n % length == 0) {
			return head;
		}
		ListNode node = head;
		for (int i = 0; i < length - n % length - 1; i++) {
			node = node.next;
		}
		prevNewHead = node;
		newHead = prevNewHead.next;
		prevNewHead.next = null;
		end.next = head;
		return newHead != null ? newHead : head;
	}
}
