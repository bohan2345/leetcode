package code;

import test.TreeNode;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p != null && q != null) {
			boolean f = p.val == q.val;
			return f && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
	}
}