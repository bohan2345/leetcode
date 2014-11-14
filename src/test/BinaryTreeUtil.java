package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

	public static TreeNode buildFromLevelOrder(String[] A) {
		TreeNode root = new TreeNode(Integer.valueOf(A[0]));
		Queue<TreeNode> S = new LinkedList<>();
		S.offer(root);
		for (int i = 1; i < A.length; i = i + 2) {
			TreeNode node = S.poll();
			if (!A[i].equals("#")) {
				node.left = new TreeNode(Integer.valueOf(A[i]));
				S.offer(node.left);
			}
			if (i + 1 < A.length && !A[i + 1].equals("#")) {
				node.right = new TreeNode(Integer.valueOf(A[i + 1]));
				S.offer(node.right);
			}
		}
		return root;
	}

	public static List<String> toListPreOrder(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<TreeNode> S = new Stack<>();
		S.push(root);
		while (!S.isEmpty()) {
			TreeNode node = S.pop();
			if (node != null) {
				res.add(Integer.toString(node.val));
				S.push(node.right);
				S.push(node.left);
			}
			else
				res.add("#");
		}
		return res;
	}

	public static List<String> toListLevelOrder(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> Q = new LinkedList<>();
		Q.offer(root);
		while (!Q.isEmpty()) {
			TreeNode node = Q.poll();
			if (node != null) {
				res.add(Integer.toString(node.val));
				Q.offer(node.left);
				Q.offer(node.right);
			} else 
				res.add("#");
		}
		return res;
	}
}
