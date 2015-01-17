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
		if (head.next == null)
            return head;
        ListNode node = head;
        for (int i = 1; i < length / 2; i++) {
            node = node.next;
        }
        ListNode head2 = node.next;
        node.next = null;
        head = mergeSort(head, length / 2);
        head2 = mergeSort(head2, length - length / 2);
        return merge(head, head2);
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
