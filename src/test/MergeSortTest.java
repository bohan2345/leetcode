package test;

import code.MergeSort;
import code.SortList;

public class MergeSortTest {
	public static void main(String[] args) {
		MergeSort test = new MergeSort();
		int[] A = { 1, 3, 5, 7 };
		int[] B = { 2, 4, 6, 8 };
		// test.mergeSort(A);
		// for (int i = 0; i < A.length; i++)
		// System.out.print(A[i]);
		ListNode node = new ListNode();
		ListNode left = node.createListNodes(A);
		ListNode right = node.createListNodes(B);

		ListNode head = test.merge(left, right);

		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}

		int[] a = { 2, 1 };
		ListNode aa = node.createListNodes(a);
		SortList sl = new SortList();
		head = sl.mergeSort(aa, 2);
		System.out.println("");
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
	}
}
