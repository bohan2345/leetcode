package code;

import java.util.ArrayList;
import java.util.List;

import test.TreeNode;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		int[] max = { root.val };
		dfs(root, max);
		return max[0];
	}

	int dfs(TreeNode root, int[] max) {
		if (root == null)
			return 0;
		int left = Math.max(dfs(root.left, max), 0);
		int right = Math.max(dfs(root.right, max), 0);
		max[0] = Math.max(max[0], left + right + root.val);
		return Math.max(left, right) + root.val;
	}
}
