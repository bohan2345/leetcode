package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import test.inorderTraversalTest.TreeNode;

public class InorderTraversal {

//	public ArrayList<Integer> inorderTraversal(TreeNode root) {
//		ArrayList<Integer> vals = new ArrayList<Integer>();
//		if (root != null) {
//			traversal(root, vals);
//		}
//		return vals;
//	}
//
//	public void traversal(TreeNode root, ArrayList<Integer> vals) {
//		if (root != null) {
//			traversal(root.left, vals);
//			vals.add(root.val);
//			traversal(root.right, vals);
//		} else
//			return;
//	}
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> results = new ArrayList<>();
		if (root == null) {
			return results;
		}
		Stack<TreeNode> S = new Stack<>();
		S.push(root);
		Set<TreeNode> visited = new HashSet<>();
		while (!S.isEmpty()) {
			TreeNode node = S.pop();
			if (visited.contains(node)) {
				results.add(node.val);
				continue;
			}
			if (node.right != null) {
				S.push(node.right);
			}
			if (node.left == null) {
				results.add(node.val);
			} else {
				S.push(node);
				S.push(node.left);
			}
			visited.add(node);
		}
		return results;
	}
}
