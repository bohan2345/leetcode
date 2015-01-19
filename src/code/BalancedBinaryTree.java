package code;

import java.util.LinkedList;
import java.util.Queue;

import test.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		boolean x = isBalanced(root.left) && isBalanced(root.right);
		return x && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
	}

	int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> Q = new LinkedList<>();
		int height = 0, cur = 1, next = 0;
		Q.offer(root);
		while (!Q.isEmpty()) {
			TreeNode node = Q.poll();
			cur--;
			if (node.left != null) {
				Q.offer(node.left);
				next++;
			}
			if (node.right != null) {
				Q.offer(node.right);
				next++;
			}
			if (cur == 0) {
				height++;
				cur = next;
				next = 0;
			}
		}
		return height;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		root.right = a;
		a.right = b;
		boolean s = new BalancedBinaryTree().isBalanced(root);
		System.out.println(s);
	}
}
