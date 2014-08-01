package code;

import java.util.ArrayList;

import test.TreeNode;

public class SumRootToLeaf {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		getAllNumbers(root, numbers, 0);
		int sum = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
		}
		return sum;
	}

	public void getAllNumbers(TreeNode node, ArrayList<Integer> numbers, int last) {
		int temp = last * 10 + node.val;
		if (node.right == null && node.left == null) {
			numbers.add(temp);
			return;
		}
		if (node.left != null) {
			getAllNumbers(node.left, numbers, temp);
		}
		if (node.right != null) {
			getAllNumbers(node.right, numbers, temp);
		}
	}
}
