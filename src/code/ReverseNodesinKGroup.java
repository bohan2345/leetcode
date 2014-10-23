package code;

import test.ListNode;

public class ReverseNodesinKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		if (k < 2) {
			return head;
		}
		ListNode prev = head;
		int i = k;
		while (i > 1) {
			prev = prev.next;
			i--;
			if (prev == null) {
				return head;
			}
		}
		ListNode node = head;
		while (head != prev) {
			node = node.next;
			head.next = prev.next;
			prev.next = head;
			head = node;
		}
		i = k;
		while (i > 1) {
			prev = prev.next;
			i--;
		}
		ListNode lastPrev = null;
		while (prev != lastPrev) {
			lastPrev = prev;
			prev = reverse(prev, k);
		}
		return head;
	}

	public ListNode reverse(ListNode prev, int k) {
		ListNode end = prev;
		int i = k;
		while (i > 0) {
			end = end.next;
			i--;
			if (end == null) {
				return prev;
			}
		}
		while (end != prev.next) {
			ListNode node = prev.next;
			prev.next = node.next;
			node.next = end.next;
			end.next = node;
		}
		prev.next = end;
		while (k > 1) {
			end = end.next;
			k--;
		}
		return end;
	}
}
