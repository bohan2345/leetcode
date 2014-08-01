package code;

import java.util.LinkedList;
import java.util.Queue;

import test.TreeNode;

public class MinDepthOfBTree {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int level = 1;
		int currentLevel = 0, nextLevel = 0;
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.add(root);
		currentLevel++;
		while (nodes.size() > 0) {
			TreeNode node = nodes.poll();
			currentLevel--;
			if (node.left == null && node.right == null) {
				break;
			}
			if (node.left != null) {
				nodes.add(node.left);
				nextLevel++;
			}
			if (node.right != null) {
				nodes.add(node.right);
				nextLevel++;
			}
			if (currentLevel == 0) {
				currentLevel = nextLevel;
				nextLevel = 0;
				level++;
			}
		}
		return level;
	}
}
