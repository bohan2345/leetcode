package code;

import test.ListNode;
import test.TreeNode;

public class SortedListToBST {
	ListNode node;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		this.node = head;
		int length = 0;
		ListNode n = head;
		while (n != null) {
			length++;
			n = n.next;
		}
		return build(0, length - 1);
	}

	public TreeNode build(int left, int right) {
		if (left > right)
			return null;
		int mid = (left + right) / 2;
		TreeNode leftChild = build(left, mid - 1);
		TreeNode root = new TreeNode(this.node.val);
		root.left = leftChild;
		this.node = this.node.next;
		TreeNode rightChild = build(mid + 1, right);
		root.right = rightChild;
		return root;
	}
}
