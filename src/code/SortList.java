package code;

import test.ListNode;

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;
		ListNode node = head;
		int length = 0;
		while (node != null) {
			node = node.next;
			length++;
		}
		return mergeSort(head, length);
	}

	public ListNode mergeSort(ListNode head, int length) {
		if (length == 1) {
			head.next = null;
			return head;
		}
		int mid = length / 2;
		ListNode node = head;
		while (mid > 0) {
			mid--;
			node = node.next;
		}
		return merge(mergeSort(head, length / 2), mergeSort(node, length - length / 2));
	}

	public ListNode merge(ListNode node1, ListNode node2) {
		ListNode head = null;
		if (node1.val > node2.val) {
			head = node2;
			node2 = node2.next;
		} else {
			head = node1;
			node1 = node1.next;
		}
		ListNode node = head;
		while (node1 != null && node2 != null) {
			if (node1.val > node2.val) {
				node.next = node2;
				node2 = node2.next;
			} else {
				node.next = node1;
				node1 = node1.next;
			}
			node = node.next;
		}
		if (node1 == null) {
			node.next = node2;
		} else {
			node.next = node1;
		}
		return head;
	}
}
