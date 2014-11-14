package test;

import code.RecoverBinarySearchTree;

public class RecoverBinarySearchTreeTest {
	public static void main(String[] args) {
		RecoverBinarySearchTree test = new RecoverBinarySearchTree();
		 String[] A = { "68", "41", "#", "-85", "#", "-73", "-49", "-98", "#", "#", "#", "-124" };
//		String[] A = { "1", "3", "#", "2", "#", "4" };
		TreeNode root = BinaryTreeUtil.buildFromLevelOrder(A);
		test.recoverTree(root);
		System.out.println(BinaryTreeUtil.toListLevelOrder(root).toString());

	}
}
