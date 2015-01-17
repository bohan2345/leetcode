package test;

import code.ReverseNodesinKGroup;

public class ReverseNodesKGroupTest {
	public static void main(String[] args) {
		ReverseNodesinKGroup test = new ReverseNodesinKGroup();
		ListNode head = new ListNode();
		int[] A = { 1, 2, 3, 4 };
		head = head.createListNodes(A);
		head = test.reverseKGroup(head, 2);
		System.out.println(head.toString());
	}
}
