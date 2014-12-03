package code;

import test.ListNode;

public class AddTwoNumber {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return add(l1, l2, 0);
	}

	public ListNode add(ListNode l1, ListNode l2, int carry) {
		ListNode node = null;
		int x = 0;
		int c = 0;
		if (l1 == null && l2 != null) {
			x = l2.val + carry;
		} else if (l1 != null && l2 == null) {
			x = l1.val + carry;
		} else if (l1 == null && l2 == null) {
			if (carry == 0)
				return null;
			else
				x = carry;
		} else {
			x = l1.val + l2.val + carry;
		}
		c = x / 10;
		x = x % 10;
		node = new ListNode(x);
		node.next = add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, c);
		return node;
	}
}
