package code;

import test.TreeNode;

public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
		return sortedArrayToBST(num, 0, num.length - 1);
	}

	public TreeNode sortedArrayToBST(int[] num, int first, int last) {
		if (first > last) {
			return null;
		}
		int mid = (first + last) / 2;
		int val = num[mid];
		TreeNode node = new TreeNode(val);
		node.left = sortedArrayToBST(num, first, mid - 1);
		node.right = sortedArrayToBST(num, mid + 1, last);
		return node;
	}
}
