package code;

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
}
