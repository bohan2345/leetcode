package code;

import test.LinkedListFactory;
import test.ListNode;

public class InsetionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode node = head.next;
        head.next = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = null;
            head = insert(head, node);
            node = tmp;
        }
        return head;
    }
    
    ListNode insert(ListNode head, ListNode node) {
        if (node.val < head.val) {
            node.next = head;
            return node;
        }
        ListNode n = head.next, prev = head;
        while (n != null) {
            if (node.val < n.val) {
                node.next = prev.next;
                prev.next = node;
                return head;
            } else {
                prev = n;
                n = n.next;
            }
        }
        prev.next = node;
        return head;
    }

	public static void main(String[] args) {
		int[] A = { 1, 4, 3};
		ListNode head = new InsetionSortList().insertionSortList(LinkedListFactory.createLinkedList(A));
		System.out.println(head.toString());
	}
}
