package code;

//Implement a LinkedList
//Must have the following methods/functions: head(), tail(), add(Object), addAfter(Node,Object), delete(Object)
//Do not maintain a reference/pointer to the tail node

class MyLinkedList {
	private Node head;

	class Node {
		public Object val;
		public Node next;

		public Node(Object obj) {
			this.val = obj;
		}
	}

	public Node head() {
		return this.head;
	}

	public Node tail() {
		Node node = this.head;
		while (node != null) {
			if (node.next == null)
				return node;
			node = node.next;
		}
		return null;
	}

	public void add(Object obj) {
		this.tail().next = new Node(obj);
	}

	public void addAfter(Node prev, Object obj) {
		Node node = this.head;
		while (node != null) {
			if (prev.equals(node)) {
				Node newNode = new Node(obj);
				newNode.next = prev.next;
				prev.next = newNode;
			}
			node = node.next;
		}
	}

	public void delete(Object obj) {
		Node node = this.head;
		Node prev = new Node(0);
		prev.next = node;
		while (node != null) {
			if (node.val.equals(obj)) {
				if (node == this.head) {
					this.head = node.next;
				}
				removeAfter(prev, node);
				break;
			}
			node = node.next;
		}
	}

	private void removeAfter(Node prev, Node node) {
		prev.next = node.next;
		node.next = null;
	}
}