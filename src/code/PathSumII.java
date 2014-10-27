package code;

import java.util.ArrayList;
import java.util.List;

import test.TreeNode;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		dfs(root, sum, 0, res, new ArrayList<Integer>());
		return res;
	}

	public void dfs(TreeNode root, int targetSum, int sum, List<List<Integer>> res, List<Integer> tmp) {
		tmp.add(root.val);
		if (root.right == null && root.left == null) {
			if (sum + root.val == targetSum)
				res.add(new ArrayList<Integer>(tmp));
			return;
		}
		if (root.left != null) {
			dfs(root.left, targetSum, sum + root.val, res, tmp);
			tmp.remove(tmp.size() - 1);
		}
		if (root.right != null) {
			dfs(root.right, targetSum, sum + root.val, res, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
}
