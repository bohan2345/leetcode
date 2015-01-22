package code;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private Map<Integer, DListNode> table;
	private final int N;
	private DListNode head;

	public LRUCache(int capacity) {
		N = capacity;
		table = new HashMap<Integer, DListNode>(capacity);
	}

	public int get(int key) {
		DListNode node = table.get(key);
		if (node == null)
			return -1;
		remove(node);
		addFirst(node);
		return node.value;
	}

	public void set(int key, int value) {
		DListNode node = null;
		if (!table.containsKey(key)) {
			node = new DListNode(key, value);
			addFirst(node);
			if (table.size() == N) {
				DListNode last = head.prev;
				remove(last);
				table.remove(last.key);
			}
		}
		else {
			node = table.get(key);
			node.value = value;
			remove(node);
			addFirst(node);
		}
		table.put(key, node);
	}

	class DListNode {
		DListNode next;
		DListNode prev;
		int key;
		int value;

		public DListNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public void addFirst(DListNode node) {
		if (head == null) {
			node.next = node;
			node.prev = node;
		} else {
			node.next = head;
			node.prev = head.prev;
			head.prev.next = node;
			head.prev = node;
		}
		head = node;
	}

	public void remove(DListNode node) {
		if (node == head && node == node.next) {
			head = null;
			return;
		}
		if (node == head)
			head = node.next;
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}
}