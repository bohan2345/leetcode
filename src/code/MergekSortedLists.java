package code;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
	
    public ListNode mergeKListsII(List<ListNode> lists) {
        Queue<ListNode> Q = new PriorityQueue<>(11, new NodeComparator());
        for (int i = 0; i < lists.size(); i++) {
            ListNode node = lists.get(i);
            while (node != null) {
                Q.offer(node);
                ListNode tmp = node.next;
                node.next = null;
                node = tmp;
            }
        }
        ListNode head = Q.poll();
        ListNode node = head;
        while (!Q.isEmpty()) {
            node.next = Q.poll();
            node = node.next;
        }
        return head;
    }
    
    class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode n1, ListNode n2) {
            if (n1.val > n2.val)
                return 1;
            else if (n1.val < n2.val)
                return -1;
            else 
                return 0;
        }
    }
}
