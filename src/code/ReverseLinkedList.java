package code;

import test.ListNode;

public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        newHead.next = head;
        int l = n - m;
        while (m > 1) {
            m--;
            prev = prev.next;
        }
        ListNode node = prev.next;
        while (l > 0) {
            l--;
            ListNode tmp = node.next;
            node.next = tmp.next;
            tmp.next = prev.next;
            prev.next = tmp;
        }
        return newHead.next;
    }
}
