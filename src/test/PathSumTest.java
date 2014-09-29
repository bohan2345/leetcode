package test;

import code.PathSum;

public class PathSumTest {
	public static void main(String[] args) {
		PathSum test = new PathSum();
		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(1);
		root.left = left;
		root.right = right;
		boolean s = test.hasPathSum(root, 0);
		System.out.println(s);
	}
}
