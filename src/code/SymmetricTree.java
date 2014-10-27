package code;

import java.util.LinkedList;
import java.util.Queue;

import test.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
			return false;
		}
		Queue<TreeNode> leftNodes = new LinkedList<>();
		Queue<TreeNode> rightNodes = new LinkedList<>();
		leftNodes.offer(root.left);
		rightNodes.offer(root.right);
		while (!leftNodes.isEmpty() && !rightNodes.isEmpty()) {
			TreeNode left = leftNodes.poll();
			TreeNode right = rightNodes.poll();
			if (left.val != right.val) {
				return false;
			}
			if (left.left != null && right.right != null) {
				leftNodes.offer(left.left);
				rightNodes.offer(right.right);
			} else if (left.left == null && right.right == null) {
			} else {
				return false;
			}
			if (left.right != null && right.left != null) {
				leftNodes.offer(left.right);
				rightNodes.offer(right.left);
			} else if (left.right == null && right.left == null) {
			} else {
				return false;
			}
		}
		return true;
	}
}
