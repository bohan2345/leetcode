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
	
	public ListNode swapPairsII(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        swap(newHead);
        return newHead.next;
    }
    
    void swap(ListNode prev) {
        if (prev.next == null || prev.next.next == null)
            return;
        ListNode node1 = prev.next;
        ListNode node2 = prev.next.next;
        prev.next = node2;
        node1.next = node2.next;
        node2.next = node1;
        swap(prev.next.next);
    }
}
