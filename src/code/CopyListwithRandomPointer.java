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
        RandomListNode node = head.next, newNode = newHead;
        while (node != null) {
            newNode.next = new RandomListNode(node.label);
            newNode = newNode.next;
            table.put(node, newNode);
            node = node.next;
        }
        node = head; newNode = newHead;
        while (node != null) {
            newNode.random = table.get(node.random);
            newNode = newNode.next;
            node = node.next;
        }
        return newHead;
    }
}
