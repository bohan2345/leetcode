package code;

import java.util.ArrayList;
import java.util.List;

import test.TreeNode;

public class UniqueBSTII {
	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> res = new ArrayList<>();
		if (start > end) {
			res.add(null);
			return res;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftNodes = generateTrees(start, i - 1);
			List<TreeNode> rightNodes = generateTrees(i + 1, end);
			for (int left = 0; left < leftNodes.size(); left++) {
				for (int right = 0; right < rightNodes.size(); right++) {
					TreeNode root = new TreeNode(i);
					root.left = leftNodes.get(left);
					root.right = rightNodes.get(right);
					res.add(root);
				}
			}
		}
		return res;
	}
}
