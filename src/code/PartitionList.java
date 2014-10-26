package code;

import test.ListNode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode smallNode = null, bigNode = head, beforeSmall = null, beforeBig = null;
		while (bigNode != null && bigNode.val < x) {
			beforeBig = bigNode;
			bigNode = bigNode.next;
		}
		smallNode = bigNode;
		while (bigNode != null && smallNode != null) {
			while (smallNode != null && smallNode.val >= x) {
				beforeSmall = smallNode;
				smallNode = smallNode.next;
			}
			if (smallNode != null) {
				if (bigNode.next == smallNode) {
					if (beforeBig != null) {
						beforeBig.next = smallNode;
						beforeBig = smallNode;
					}
					bigNode.next = smallNode.next;
					smallNode.next = bigNode;
				} else {
					if (beforeBig != null) {
						beforeBig.next = smallNode;
						beforeBig = smallNode;
					}
					beforeSmall.next = smallNode.next;
					smallNode.next = bigNode;
				}
				if (beforeBig == null) {
					head = smallNode;
					beforeBig = head;
				}
			}
			if (beforeSmall != null)
				smallNode = beforeSmall.next;
		}
		return head;
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
