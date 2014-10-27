package code;

import test.TreeNode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		return dfs(root, 0, sum);
	}

	public boolean dfs(TreeNode node, int sum, int target) {
		sum = sum + node.val;
		if (node.left == null && node.right == null) {
			if (sum == target) {
				return true;
			} else {
				return false;
			}
		}
		if (node.left != null) {
			if (dfs(node.left, sum, target)) {
				return true;
			}
		}
		if (node.right != null) {
			if (dfs(node.right, sum, target)) {
				return true;
			}
		}
		return false;
	}
}
