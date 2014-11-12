package tc;

import java.util.Stack;

import test.TreeNode;

public class BuildTreeFromArray {
	public TreeNode build(int[] A) {
		TreeNode root = new TreeNode(A[0]);
		TreeNode last = root;
		Stack<TreeNode> S = new Stack<>();
		boolean left = false;
		for (int i = 1; i < A.length; i++) {
			if (last == null && S.isEmpty())
				break;
			last = last == null ? S.pop() : last;
			if (A[i] != -1) {
				TreeNode node = new TreeNode(A[i]);
				if (!left) {
					S.push(last);
					last.left = node;
					last = last.left;
				} else {
					last.right = node;
					last = last.right;
				}
				left = false;
			} else if (A[i] == -1) {
				if (!left)
					left = true;
				else
					last = null;
			}
		}
		return root;
	}
}
