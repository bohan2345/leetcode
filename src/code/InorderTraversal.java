package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import test.TreeNode;

public class InorderTraversal {
	// public List<Integer> inorderTraversal(TreeNode root) {
	// List<Integer> res = new ArrayList<>();
	// inorderTraversal(root, res);
	// return res;
	// }
	//
	// public void inorderTraversal(TreeNode root, List<Integer> res) {
	// if (root == null)
	// return;
	// inorderTraversal(root.left, res);
	// res.add(root.val);
	// inorderTraversal(root.right, res);
	// }

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		TreeNode current = root;
		Stack<TreeNode> S = new Stack<TreeNode>();
		while (!S.isEmpty() || current != null) {
			if (current == null) {
				current = S.pop();
				result.add(current.val);
				current = current.right;
			} else {
				S.push(current);
				current = current.left;
			}
		}
		return result;
	}
}
