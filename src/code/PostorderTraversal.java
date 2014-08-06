package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import test.TreeNode;

public class PostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> vals = new ArrayList<Integer>();
		if (root == null)
			return vals;
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		Set<TreeNode> visited = new HashSet<TreeNode>();
		nodes.push(root);
		while (nodes.size() > 0) {
			TreeNode n = nodes.peek();
			if (visited.contains(n) || (n.left == null && n.right == null)) {
				TreeNode node = nodes.pop();
				vals.add(node.val);
				continue;
			} else {
				if (n.right != null) {
					nodes.push(n.right);
				}
				if (n.left != null) {
					nodes.push(n.left);
				}
			}
			visited.add(n);
		}
		return vals;
	}
}
