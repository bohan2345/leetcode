package code;

import test.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode slow = head, fast = head;
		while (true) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
			if (slow == null || fast == null)
				return false;
			if (slow == fast)
				return true;
		}
	}
}
