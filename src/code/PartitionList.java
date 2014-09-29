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
}
