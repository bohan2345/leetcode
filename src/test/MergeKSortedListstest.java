package test;

import java.util.ArrayList;
import java.util.List;

import code.MergekSortedLists;

public class MergeKSortedListstest {
	public static void main(String[] args) {
		List<ListNode> L = new ArrayList<>();
		int[] A = { -2, -1, -1, -1 };
		L.add(LinkedListFactory.createLinkedList(A));
		L.add(null);
		MergekSortedLists test = new MergekSortedLists();
		
		System.out.println(test.mergeKListsII(L).toString());
	}
}
