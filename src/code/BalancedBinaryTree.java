package code;

import java.util.LinkedList;
import java.util.Queue;

import test.inorderTraversalTest.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		else if (root.left != null && root.right == null) {
			if (maxDepth(root.left) > 1) {
				return false;
			} else {
				return true;
			}
		} else if (root.right != null && root.left == null) {
			if (maxDepth(root.right) > 1) {
				return false;
			} else {
				return true;
			}
		} else{
		   boolean x = (maxDepth(root.left)-maxDepth(root.right)<2)&&(maxDepth(root.left)-maxDepth(root.right)>-2);
		   return x&&isBalanced(root.left)&&isBalanced(root.right);
		}
		
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		int current = 0, next = 0, depth = 0;
		nodes.add(root);
		current++;
		while (nodes.size() > 0) {
			TreeNode node = nodes.poll();
			current--;
			if (node.left != null) {
				nodes.add(node.left);
				next++;
			}
			if (node.right != null) {
				nodes.add(node.right);
				next++;
			}
			if (current == 0) {
				current = next;
				next = 0;
				depth++;
			}
		}
		return depth;
	}
}
