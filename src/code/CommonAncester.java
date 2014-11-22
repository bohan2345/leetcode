package code;

import test.TreeNode;

public class CommonAncester {
	public TreeNode findCommonAnsester(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null)
			return null;
		if (root == node1)
			return node1;
		if (root == node2)
			return node2;
		TreeNode left = findCommonAnsester(root.left, node1, node2);
		TreeNode right = findCommonAnsester(root.right, node1, node2);
		if (left != null && right != null)
			return root;
		if (left != null)
			return left;
		if (right != null)
			return right;
		return null;
	}
}
