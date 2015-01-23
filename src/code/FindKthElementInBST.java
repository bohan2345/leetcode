package code;

import test.BinaryTreeUtil;
import test.TreeNode;

/*
 * find the Kth minimum element in BST
 */
public class FindKthElementInBST {
	boolean f = false;

	public void find(TreeNode root, int[] k, int[] res) {
		if (root == null || k[0] == 0) {
			return;
		}
		if (!f && root.left == null) {
			f = true;
		}
		find(root.left, k, res);
		if (k[0] != 0) {
			res[0] = root.val;
			k[0]--;
		}
		find(root.right, k, res);
	}

	public static void main(String[] args) {
		FindKthElementInBST test = new FindKthElementInBST();
		int[] res = { 0 };
		int[] k = { 1 };
		TreeNode root = BinaryTreeUtil.buildFromLevelOrder(new String[] { "5", "3", "6", "1", "4", "#", "7", "#", "2" });
		test.find(root, k, res);
		System.out.println(res[0]);
	}
}
