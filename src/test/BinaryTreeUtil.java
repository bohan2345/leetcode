package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeUtil {
	public static TreeNode buildFromInOrder(char[] A) {
		TreeNode root = new TreeNode(Character.getNumericValue(A[0]));
		TreeNode last = root;
		Stack<TreeNode> S = new Stack<>();
		boolean left = false;
		for (int i = 1; i < A.length; i++) {
			if (last == null && S.isEmpty())
				break;
			last = last == null ? S.pop() : last;
			if (A[i] != '#') {
				TreeNode node = new TreeNode(Character.getNumericValue(A[0]));
				if (!left) {
					S.push(last);
					last.left = node;
					last = last.left;
				} else {
					last.right = node;
					last = last.right;
				}
				left = false;
			} else if (A[i] == '#') {
				if (!left)
					left = true;
				else
					last = null;
			}
		}
		return root;
	}

	public static List<Character> toList(TreeNode root) {
		List<Character> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<TreeNode> S = new Stack<>();
		S.push(root);
		while (!S.isEmpty()) {
			TreeNode node = S.pop();
			if (node != null) {
				res.add(Integer.toString(node.val).charAt(0));
				S.push(node.right);
				S.push(node.left);
			}
			else
				res.add('#');
		}
		return res;
	}
}
