package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import test.BinaryTreeUtil;
import test.TreeNode;

public class BinaryTreeLongestPath {
	public List<TreeNode> longestPath(TreeNode root) {
		List<TreeNode> res = new ArrayList<>();
		List<Integer> x = new ArrayList<>();
		List<TreeNode> y = new ArrayList<>();
		x.add(Integer.MIN_VALUE);
		y.add(root);
		Search(root, y, x);

		TreeNode node = y.get(0);
		res = longestPathToleaf(node.left);
		List<TreeNode> tmp = longestPathToleaf(node.right);
		res.add(node);
		for (int i = tmp.size() - 1; i >= 0; i--) {
			res.add(tmp.get(i));
		}
		return res;
	}

	private int Search(TreeNode root, List<TreeNode> maxNode, List<Integer> max) {
		if (root == null)
			return 0;
		int left = Search(root.left, maxNode, max);
		int right = Search(root.right, maxNode, max);
		if (left + right > max.get(0)) {
			maxNode.remove(0);
			maxNode.add(root);
			max.remove(0);
			max.add(left + right);
		}
		return Math.max(left, right) + 1;
	}

	private List<TreeNode> longestPathToleaf(TreeNode root) {
		List<TreeNode> res = new ArrayList<>();
		Map<TreeNode, TreeNode> table = new HashMap<>();
		Queue<TreeNode> Q = new LinkedList<>();
		Q.offer(root);
		TreeNode node = null;
		while (!Q.isEmpty()) {
			node = Q.poll();
			if (node.left != null) {
				table.put(node.left, node);
				Q.offer(node.left);
			}
			if (node.right != null) {
				table.put(node.right, node);
				Q.offer(node.right);
			}
		}
		while (table.containsKey(node)) {
			res.add(node);
			node = table.get(node);
		}
		res.add(node);
		return res;
	}

	public static void main(String[] args) {
		BinaryTreeLongestPath test = new BinaryTreeLongestPath();
		TreeNode root = BinaryTreeUtil.buildFromLevelOrder(new String[] { "0", "#", "1", "2", "3", "4", "5", "#", "#", "#", "#", "6", "#" });

		System.out.println(test.longestPath(root).toString());
	}
}
