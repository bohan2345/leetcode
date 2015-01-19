package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import test.TreeNode;

public class InorderTraversal {
//	public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<>();
//		inorderTraversal(root, res);
//		return res;
//	}
//
//	public void inorderTraversal(TreeNode root, List<Integer> res) {
//		if (root == null)
//			return;
//		inorderTraversal(root.left, res);
//		res.add(root.val);
//		inorderTraversal(root.right, res);
//	}

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
