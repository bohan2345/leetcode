package test;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	};

	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	public ListNode createListNodes(int[] x) {
		ListNode lastnode = new ListNode(x[0]);
		ListNode head = lastnode;
		for (int i = 1; i < x.length; i++) {
			ListNode node = new ListNode(x[i]);
			lastnode.next = node;
			lastnode = lastnode.next;
		}
		return head;
	}

	@Override
	public String toString() {
		ListNode head = this;
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val + ", ");
			head = head.next;
		}
		return sb.toString();
	}
}
