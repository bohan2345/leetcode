package test;

import code.SwapNodesPairs;

public class SwapNodesPairsTest {
	public static void main(String[] args) {
		int[] x = { 1, 2, 3 };
		ListNode node = new ListNode();
		ListNode head = node.createListNodes(x);

		SwapNodesPairs test = new SwapNodesPairs();
		ListNode newhead = test.swapPairs(head);

		while (newhead.next != null) {
			System.out.print(newhead.val);
			newhead = newhead.next;
		}
		System.out.println(newhead.val);
	}
}
