package code;

import test.TreeNode;

public class CommonAncester {
	/*
	 * This approach work fine when two nodes are ensured existing in the tree TODO: still need analysis,
	 */
	public TreeNode findCommonAnsester(TreeNode root, TreeNode node1, TreeNode node2) {
		boolean finded[] = new boolean[2];
		TreeNode commonAnsester = findCommonAnsester(root, node1, node2, finded);
		if (finded[0] && finded[1])
			return commonAnsester;
		else
			return null;
	}

	private TreeNode findCommonAnsester(TreeNode root, TreeNode node1, TreeNode node2, boolean[] finded) {
		if (root == null)
			return null;
		if (root == node1) {
			finded[0] = true;
			if (!finded[1]) {
				findCommonAnsester(root.left, node1, node2, finded);
				findCommonAnsester(root.right, node1, node2, finded);
			}
			return node1;
		}
		if (root == node2) {
			finded[1] = true;
			if (finded[0]) {
				findCommonAnsester(root.left, node1, node2, finded);
				findCommonAnsester(root.right, node1, node2, finded);
			}
			return node2;
		}
		TreeNode left = findCommonAnsester(root.left, node1, node2, finded);
		TreeNode right = findCommonAnsester(root.right, node1, node2, finded);
		if (left != null && right != null)
			return root;
		if (left != null)
			return left;
		if (right != null)
			return right;
		return null;
	}
}
