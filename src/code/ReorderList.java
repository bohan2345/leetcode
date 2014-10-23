package code;

import test.ListNode;

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode node = head;
		int length = 0;
		while (node != null) {
			node = node.next;
			length++;
		}
		int mid = (length + 1) / 2;
		node = head;
		while (mid > 1) {
			node = node.next;
			mid--;
		}
		ListNode head2 = node.next;
		node.next = null;
		head2 = reverse(head2);
		head = merge(head, head2);
	}

	public ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode end = head;
		while (end.next != null) {
			end = end.next;
		}
		ListNode node = head;
		while (node != end) {
			ListNode tmp = node.next;
			node.next = end.next;
			end.next = node;
			node = tmp;
		}
		return end;
	}

	public ListNode merge(ListNode A, ListNode B) {
		ListNode head = A;
		A = A.next;
		ListNode node = head;
		int count = 0;
		while (A != null || B != null) {
			if (count % 2 == 0) {
				node.next = B;
				B = B.next;
			} else {
				node.next = A;
				A = A.next;
			}
			node = node.next;
			count++;
		}
		return head;
	}
}
