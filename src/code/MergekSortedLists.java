package code;

import java.util.List;

import test.ListNode;

public class MergekSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		return mergeKLists(lists, 0, lists.size() - 1);
	}

	public ListNode mergeKLists(List<ListNode> lists, int start, int end) {
		if (start == end) {
			return lists.get(end);
		}
		int mid = start + (end - start) / 2;
		ListNode left = mergeKLists(lists, start, mid);
		ListNode right = mergeKLists(lists, mid + 1, end);
		return merge(left, right);
	}

	public ListNode merge(ListNode left, ListNode right) {
		if (left == null && right != null) {
			return right;
		} else if (left != null && right == null) {
			return left;
		} else if (left == null && right == null) {
			return null;
		}
		ListNode head = null;
		if (left.val > right.val) {
			head = right;
			right = right.next;
		} else {
			head = left;
			left = left.next;
		}
		ListNode node = head;
		while (left != null && right != null) {
			if (left.val > right.val) {
				node.next = right;
				right = right.next;
			} else {
				node.next = left;
				left = left.next;
			}
			node = node.next;
		}
		if (left == null) {
			node.next = right;
		} else {
			node.next = left;
		}
		return head;
	}
}
