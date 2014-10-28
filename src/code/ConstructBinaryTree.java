package code;

import test.TreeNode;

public class ConstructBinaryTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
		if (pstart > pend || istart > iend) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[pstart]);
		int index = istart;
		for (int i = istart; i <= iend; i++) {
			if (preorder[pstart] == inorder[i]) {
				index = i;
				break;
			}
		}
		root.left = build(preorder, pstart + 1, pstart + index - istart, inorder, istart, index - 1);
		root.right = build(preorder, pstart + index - istart + 1, pend, inorder, index + 1, iend);
		return root;
	}
}
