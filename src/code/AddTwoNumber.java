package code;

import test.ListNode;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }
    
    ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0)
            return null;
        int n1 = l1 == null ? 0 : l1.val;
        int n2 = l2 == null ? 0 : l2.val;
        int n = n1 + n2 + carry;
        ListNode node = new ListNode(n % 10);
        carry = n / 10;
        node.next = add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
        return node;
    }
}
