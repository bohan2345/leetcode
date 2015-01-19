package code;

import java.util.LinkedList;
import java.util.Queue;

import test.TreeNode;

public class BtreeMaxDepth {
	public int maxDepth(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int maxDepth = 0;
		int current = 0, next = 0;
		TreeNode node;
		q.add(root);
		current++;
		while ((node = q.poll()) != null) {
			current--;
			if (node.left != null) {
				q.add(node.left);
				next++;
			}
			if (node.right != null) {
				q.add(node.right);
				next++;
			}
			if (current == 0) {
				maxDepth++;
				current = next;
				next = 0;
			}
		}
		return maxDepth;
	}
}
