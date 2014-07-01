package code;

import java.util.ArrayList;

import test.inorderTraversalTest.TreeNode;

public class InorderTraversal {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> vals = new ArrayList<Integer>();
		if (root != null) {
			traversal(root, vals);
		}
		return vals;
	}

	public void traversal(TreeNode root, ArrayList<Integer> vals) {
		if (root != null) {
			traversal(root.left, vals);
			vals.add(root.val);
			traversal(root.right, vals);
		} else
			return;
	}
}
