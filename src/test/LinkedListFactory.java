package test;

public class LinkedListFactory {
	public static ListNode createLinkedList(int[] x) {
		ListNode lastnode = new ListNode(x[0]);
		ListNode head = lastnode;
		for (int i = 1; i < x.length; i++) {
			ListNode node = new ListNode(x[i]);
			lastnode.next = node;
			lastnode = lastnode.next;
		}
		return head;
	}

	public static String toString(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val + ", ");
			head = head.next;
		}
		return sb.toString();
	}

	public static ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode begin = new ListNode(0);
		begin.next = head;
		ListNode node = head, lastNode = node;
		while (node.next != null) {
			// remove node.next
			ListNode tmp = node.next;
			node.next = tmp.next;
			// insert it after begin
			tmp.next = lastNode;
			begin.next = tmp;
			lastNode = tmp;
		}
		return begin.next;
	}
}
