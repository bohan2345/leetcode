package code;

import java.util.LinkedList;
import java.util.Queue;

import test.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		if (root.left != null && root.right != null) {
			Queue<TreeNode> nodes1 = new LinkedList<TreeNode>();
			Queue<TreeNode> nodes2 = new LinkedList<TreeNode>();
			nodes1.add(root.left);
			nodes2.add(root.right);
			while (nodes1.size() > 0 && nodes2.size() > 0) {
				TreeNode node1 = nodes1.poll();
				TreeNode node2 = nodes2.poll();
				if (node1.val != node2.val) {
					return false;
				}
				if (node1.left != null && node2.right != null) {
					nodes1.add(node1.left);
					nodes2.add(node2.right);
				} else if (node1.left == null && node2.right == null) {

				} else
					return false;
				if (node1.right != null && node2.left != null) {
					nodes1.add(node1.right);
					nodes2.add(node2.left);
				} else if (node1.right == null && node2.left == null) {

				} else
					return false;
			}
		} else
			return false;
		return true;
	}
}
