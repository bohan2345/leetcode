package test;

import code.PartitionList;

public class PartitionListTest {
	public static void main(String[] args) {
		PartitionList test = new PartitionList();
		ListNode create = new ListNode();
		int[] x = { 3, 1, 2 };
		ListNode head = create.createListNodes(x);
		test.partition(head, 3);
	}
}
