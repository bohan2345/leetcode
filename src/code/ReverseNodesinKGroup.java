package code;

import test.ListNode;

public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode node = head, end = head;
        for (int i = 0; i < k; i++) {
            if (node == null)
                return head;
            end = node;
            node = node.next;
        }
        node = head;
        for (int i = 1; i < k; i++) {
        	ListNode tmp = node.next;
        	node.next = end.next;
            end.next = node;
            node = tmp;
        }
        head.next = reverseKGroup(head.next, k);
        return node;
    }
}
