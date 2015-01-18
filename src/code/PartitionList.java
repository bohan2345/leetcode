package code;

import test.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode newHead = less;
        ListNode greater = new ListNode(0);
        ListNode greatHead = greater;
        ListNode node = head;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = null;
            if (node.val < x) {
                less.next = node;
                less = less.next;
            } else {
                greater.next = node;
                greater = greater.next;;
            }
            node = tmp;
        }
        less.next = greatHead.next;
        return newHead.next;
    }

	public ListNode partitionII(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		ListNode smallHead = null, bigHead = null, smallEnd = null;
		smallHead = new ListNode(x - 1);
		smallHead.next = head;
		ListNode node = head, prev = smallHead;
		while (node != null && node.val < x) {
			prev = node;
			node = node.next;
		}
		bigHead = node;
		if (bigHead == null) {
			return head;
		}
		bigHead = remove(prev, bigHead);
		node = smallHead.next;
		prev = smallHead;
		ListNode bigPrev = bigHead;
		while (node != null) {
			ListNode tmp = node.next;
			if (node.val >= x) {
				node = remove(prev, node);
				bigPrev = insert(bigPrev, node);
			} else {
				prev = node;
			}
			node = tmp;
		}
		smallEnd = prev;
		smallEnd.next = bigHead;
		return smallHead.next;
	}

	public ListNode remove(ListNode prev, ListNode node) {
		prev.next = node.next;
		node.next = null;
		return node;
	}

	public ListNode insert(ListNode prev, ListNode node) {
		node.next = prev.next;
		prev.next = node;
		return node;
	}
}
