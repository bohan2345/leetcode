package code;

import test.ListNode;

public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int alength = getLength(headA);
		int blength = getLength(headB);
		if (alength > blength) {
			for (int i = 0; i < alength - blength; i++) {
				headA = headA.next;
			}
		} else if (blength > alength) {
			for (int i = 0; i < blength - alength; i++) {
				headB = headB.next;
			}
		}
		while (headA != null && headB != null) {
			if (headA.equals(headB))
				return headA;
			else {
				headA = headA.next;
				headB = headB.next;
			}
		}
		return null;
	}

	public int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			head = head.next;
			length++;
		}
		return length;
	}
}
