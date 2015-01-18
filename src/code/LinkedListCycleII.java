package code;

import test.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head, slow = head;
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
            if (slow == null || fast == null)
                return null;
            if (slow.equals(fast))
                break;
        }
        fast = head;
        while (true) {
            if (slow.equals(fast))
                break;
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
