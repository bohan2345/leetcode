package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SameTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		return sameNode(p, q);
	}

	public boolean sameNode(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}
		boolean val = (p.val == q.val);
		boolean left = sameNode(p.left, q.left);
		boolean right = sameNode(p.right, q.right);
		if (val && left && right)
			return true;
		else
			return false;
	}

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayList<Integer> vals = new ArrayList<Integer>();
		Queue<TreeNode> lnodes = new LinkedList<TreeNode>();
		Stack<TreeNode> rnodes = new Stack<TreeNode>();
		lnodes.add(root);
		TreeNode node;
		while (lnodes.size() != 0 || rnodes.size() != 0) {
			if (lnodes.size() != 0) {
				node = lnodes.poll();
			} else {
				node = rnodes.pop();
			}
			if (node.left != null) {
				lnodes.add(node.left);
			}
			if (node.right != null) {
				rnodes.push(node.right);
			}
			vals.add(node.val);
		}
		return vals;
	}
}