package code;

import java.util.ArrayList;
import java.util.Stack;

import test.TreeNode;

public class BinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		ArrayList<TreeNode> nodeArray = new ArrayList<TreeNode>();
		nodes.push(root);
		while (nodes.size() > 0) {
			TreeNode node = nodes.pop();
			nodeArray.add(node);
			if (node.right != null) {
				nodes.add(node.right);
			}
			if (node.left != null) {
				nodes.add(node.left);
			}
		}
		for (int i = 0; i < nodeArray.size(); i++) {
			TreeNode temp = nodeArray.get(i);
			if (i + 1 < nodeArray.size()) {
				temp.right = nodeArray.get(i + 1);
				temp.left = null;
			} else {
				temp.right = null;
			}
		}
	}
}
