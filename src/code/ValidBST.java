package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import test.TreeNode;

public class ValidBST {
	public boolean isValidBST(TreeNode root) {
		List<Integer> nodes = inorderTraversal(root);
		for (int i = 1; i < nodes.size(); i++) {
			if (nodes.get(i) <= nodes.get(i - 1))
				return false;
		}
		return true;
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<TreeNode> S = new Stack<>();
		S.push(root);
		Set<TreeNode> visited = new HashSet<>();
		while (!S.isEmpty()) {
			TreeNode node = S.pop();
			if (visited.contains(node)) {
				res.add(node.val);
				visited.remove(node);
				continue;
			}
			if (node.right != null) {
				S.push(node.right);
			}
			if (node.left == null) {
				res.add(node.val);
			} else {
				S.push(node);
				visited.add(node);
				S.push(node.left);
			}
		}
		return res;
	}
}
