package code;

import java.util.ArrayList;
import java.util.List;

import test.TreeNode;

public class SumRootToLeaf {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		List<Integer> res = new ArrayList<>();
		dfs(root, res, 0);
		int sum = 0;
		for (int i = 0; i < res.size(); i++) {
			sum += res.get(i);
		}
		return sum;
	}

	public void dfs(TreeNode root, List<Integer> res, int num) {
		if (root.left == null && root.right == null) {
			res.add(num * 10 + root.val);
			return;
		}
		if (root.left != null)
			dfs(root.left, res, num * 10 + root.val);
		if (root.right != null)
			dfs(root.right, res, num * 10 + root.val);
	}
}
