package code;

import java.util.ArrayList;
import java.util.List;

import test.TreeNode;

public class UniqueBSTII {
	public List<TreeNode> generateTrees(int n) {
		return build(1, n);
	}

	public List<TreeNode> build(int start, int end) {
		List<TreeNode> results = new ArrayList<>();
		if (start > end) {
			results.add(null);
			return results;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = build(start, i - 1);
			List<TreeNode> right = build(i + 1, end);
			for (int l = 0; l < left.size(); l++) {
				for (int r = 0; r < right.size(); r++) {
					TreeNode root = new TreeNode(i);
					root.left = left.get(l);
					root.right = right.get(r);
					results.add(root);
				}
			}
		}
		return results;
	}
}
