package code;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
	/**
	 * Definition for singly-linked list with a random pointer.
	 */
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode newHead = new RandomListNode(head.label);
		Map<RandomListNode, RandomListNode> table = new HashMap<>();
		table.put(head, newHead);
		RandomListNode node = head.next, prev = newHead;
		while (node != null) {
			RandomListNode newNode = new RandomListNode(node.label);
			prev.next = newNode;
			table.put(node, newNode);
			prev = prev.next;
			node = node.next;
		}
		node = head;
		prev = newHead;
		while (node != null) {
			RandomListNode ran = node.random;
			prev.random = table.get(ran);
			prev = prev.next;
			node = node.next;
		}
		return newHead;
	}
}
