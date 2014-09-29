package code;

import test.TreeNode;

public class PathSum {
	// public boolean hasPathSum(TreeNode root, int sum) {
	// if (root == null)
	// return false;
	//
	// return lalala(root, sum, 0);
	// }
	//
	// public boolean lalala(TreeNode node, int targetSum, int lastSum) {
	// if (node == null)
	// return false;
	// int currentSum = lastSum + node.val;
	// if (currentSum == targetSum) {
	// if (node.left == null && node.right == null) {
	// return true;
	// }
	// }
	//
	// boolean left = lalala(node.left, targetSum, currentSum);
	// boolean right = lalala(node.right, targetSum, currentSum);
	// return left || right;
	// }

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
