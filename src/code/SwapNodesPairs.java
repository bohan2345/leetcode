package code;

import test.ListNode;

public class SwapNodesPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode node = head;
		ListNode newHead = node.next;
		ListNode last = new ListNode(0);
		while (node != null) {
			if (node.next == null)
				break;
			ListNode temp = node.next;
			node.next = temp.next;
			temp.next = node;
			last.next = temp;
			last = node;
			node = node.next;
		}
		return newHead;
	}
}
