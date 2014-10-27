package code;

import java.util.Stack;

import test.TreeNode;

public class FlattenBinaryTree {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> S = new Stack<>();
		S.push(root);
		TreeNode prev = new TreeNode(0);
		while (!S.isEmpty()) {
			TreeNode node = S.pop();
			if (node.right != null) {
				S.push(node.right);
			}
			if (node.left != null) {
				S.push(node.left);
			}
			node.left = null;
			node.right = null;
			prev.right = node;
			prev = node;
		}
	}
}
