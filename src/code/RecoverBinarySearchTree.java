package code;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import test.TreeNode;

public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		TreeNode[] nodes = find(root);
		int i = nodes[0].val;
		nodes[0].val = nodes[1].val;
		nodes[1].val = i;
	}

	boolean down = false;
	TreeNode tmp = new TreeNode(Integer.MIN_VALUE);

	private TreeNode[] find(TreeNode root) {
		TreeNode[] nodes = new TreeNode[2];
		inorder(root, nodes);
		if ((nodes[0] != null && nodes[1] == null) || down)
			nodes[1] = tmp;
		return nodes;
	}

	private void inorder(TreeNode root, TreeNode[] nodes) {
		if (root == null)
			return;
		inorder(root.left, nodes);
		if (root.val < tmp.val) {
			down = true;
			nodes[0] = nodes[0] == null ? tmp : nodes[0];
		}
		if (root.val > tmp.val && down) {
			nodes[1] = tmp;
			down = false;
		}
		tmp = root;
		inorder(root.right, nodes);
	}

	public void recoverTreeII(TreeNode root) {
		if (root == null)
			return;
		TreeNode[] pair = new TreeNode[2];
		Stack<TreeNode> S = new Stack<>();
		S.push(root);
		Set<TreeNode> visited = new HashSet<>();
		TreeNode last = new TreeNode(Integer.MIN_VALUE);
		while (!S.isEmpty()) {
			TreeNode node = S.pop();
			if (visited.contains(node)) {
				if (pair[1] != null) {
					if (node.val < pair[1].val) {
						pair[1] = node;
					}
				} else {
					if (last.val > node.val) {
						pair[0] = last;
						pair[1] = node;
					}
					last = node;
				}
				continue;
			}
			visited.add(node);
			if (node.right != null)
				S.push(node.right);
			S.push(node);
			if (node.left != null)
				S.push(node.left);
		}
		int tmp = pair[0].val;
		pair[0].val = pair[1].val;
		pair[1].val = tmp;
	}
}
