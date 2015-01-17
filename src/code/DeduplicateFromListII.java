package code;

import test.ListNode;

public class DeduplicateFromListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode newHead = new ListNode(head.val - 1);
        newHead.next = head;
        ListNode node = head;
        ListNode prev = newHead;
        boolean dup = false;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                dup = true;
            } else {
                if (dup) {
                    prev.next = node.next;
                } else {
                    prev = node;
                }
                node = node.next;
                dup = false;
            }
        }
        if (dup) {
            prev.next = node.next;
        }
        return newHead.next;
    }
}
