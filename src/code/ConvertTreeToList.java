package code;

import test.ListNode;
import test.TreeNode;

public class ConvertTreeToList {
	ListNode node;

	public ListNode convert(TreeNode root) {
		node = new ListNode(0);
		ListNode head = node;
		convertTree(root);
		return head.next;
	}

	public void convertTree(TreeNode root) {
		if (root == null) {
			return;
		}
		convertTree(root.left);
		node.next = new ListNode(root.val);
		node = node.next;
		convertTree(root.right);
	}
}
