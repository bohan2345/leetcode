package code;

import test.ListNode;

public class ReverseLinkedList {
//	public ListNode reverseBetween(ListNode head, int m, int n) {
//		ListNode mNode = head, nNode = null, beforeM = null, begin = null;
//		for (int i = 1; i < m; i++) {
//			begin = mNode;
//			mNode = mNode.next;
//		}
//		nNode = mNode;
//		for (int i = 0; i < n - m; i++) {
//			beforeM = nNode;
//			if (begin == null) {
//				nNode = mNode.next;
//				mNode.next = nNode.next;
//				nNode.next = beforeM;
//				head = nNode;
//			} else {
//				nNode = mNode.next;
//				begin.next = nNode;
//				mNode.next = nNode.next;
//				nNode.next = beforeM;
//			}
//		}
//		return head;
//	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n){
			return head;
		}
		ListNode beforeM = null, mNode = head, tmp = null, begin = null, first = null;
		for (int i = 1; i < m; i++) {
		    beforeM = mNode;
		    mNode = mNode.next;
		}
		begin = beforeM;
		first = mNode;
		for (int i = 0; i <= n - m; i++) {
		    tmp = mNode;
		    mNode = mNode.next;
		    tmp.next = beforeM;
		    beforeM = tmp;
		}
		if (begin != null) {
		    begin.next = beforeM;
		} else {
		    head = beforeM;
		}
		first.next = mNode;
		
		return head;
	}
}
