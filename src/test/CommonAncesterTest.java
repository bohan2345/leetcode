package test;

import code.CommonAncester;

public class CommonAncesterTest {
	public static void main(String[] args) {
		CommonAncester test = new CommonAncester();
		String[] A = { "1", "2", "3", "4", "5", "#", "#", "#", "#", "6", "7" };
		TreeNode root = BinaryTreeUtil.buildFromLevelOrder(A);
		TreeNode node1 = root;
		TreeNode node2 = root.left.right.left;
		TreeNode x = test.findCommonAnsester(root, node1, node2);
		System.out.println(x);
	}
}
