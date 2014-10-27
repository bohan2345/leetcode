package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import test.inorderTraversalTest.TreeNode;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		int curLevel = 0, nextLevel = 0;
		Queue<TreeNode> Q = new LinkedList<>();
		Q.offer(root);
		curLevel++;
		List<Integer> tmp = new ArrayList<>();
		while (!Q.isEmpty()) {
			TreeNode node = Q.poll();
			curLevel--;
			tmp.add(node.val);
			if (node.left != null) {
				Q.offer(node.left);
				nextLevel++;
			}
			if (node.right != null) {
				Q.offer(node.right);
				nextLevel++;
			}
			if (curLevel == 0) {
				List<Integer> l = new ArrayList<>(tmp);
				tmp.clear();
				res.add(l);
				curLevel = nextLevel;
				nextLevel = 0;
			}
		}
		return res;
	}
}
