package code;

import test.TreeNode;

public class BinarySearchTree {
	TreeNode root;

	public void add(int i) {
		if (root == null) {
			root = new TreeNode(i);
		} else {
			add(i, root);
		}
	}

	private void add(int i, TreeNode root) {
		if (i < root.val) {
			if (root.left == null)
				root.left = new TreeNode(i);
			else
				add(i, root.left);
		} else if (i > root.val) {
			if (root.right == null)
				root.right = new TreeNode(i);
			else
				add(i, root.right);
		}
	}

	public TreeNode find(int i) {
		return find(i, root);
	}

	private TreeNode find(int i, TreeNode root) {
		if (i < root.val) {
			if (root.left != null) {
				return find(i, root.left);
			} else
				return null;
		} else if (i > root.val) {
			if (root.right != null) {
				return find(i, root.right);
			} else
				return null;
		} else
			return root;
	}

	public boolean delete(int i) {
		TreeNode node = find(i);
		if (node == null)
			return false;
		TreeNode parent = getParent(node);
		if (node.left == null && node.right == null) {
			if (node.equals(parent.left)) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (node.left == null) {
			if (node.equals(parent.left)) {
				parent.left = node.right;
			} else {
				parent.right = node.right;
			}
			node.right = null;
		} else if (node.right == null) {
			if (node.equals(parent.left)) {
				parent.left = node.left;
			} else {
				parent.right = node.left;
			}
			node.left = null;
		} else {
			TreeNode min = getMin(node.right);
			int tmp = node.val;
			node.val = min.val;
			min.val = tmp;
			delete(min.val);
		}
		return true;
	}

	public TreeNode getMin(TreeNode root) {
		if (root == null)
			return null;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	private TreeNode getParent(TreeNode node) {
		TreeNode parent = null;
		TreeNode root = this.root;
		while (root != null) {
			if (node.val < root.val) {
				parent = root;
				root = root.left;
			} else if (node.val > root.val) {
				parent = root;
				root = root.right;
			} else {
				break;
			}
		}
		return parent;
	}

	public BSTIterator iterater() {
		return new BSTIterator(root);
	}
}
