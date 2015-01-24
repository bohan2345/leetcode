package code;

import java.util.Stack;

import test.TreeNode;

public class BSTIterator {
	private Stack<TreeNode> S;
	private TreeNode root;

	public BSTIterator(TreeNode root) {
		this.S = new Stack<>();
		this.root = root;
	}

	/** 
	 * @return whether we have a next smallest number 
	 * */
	public boolean hasNext() {
		return !S.isEmpty() || root != null;
	}

	/** 
	 * @return the next smallest number 
	 * */
	public int next() {
		while (hasNext()) {
			if (root != null) {
				S.push(root);
				root = root.left;
			} else {
				root = S.pop();
				int r = root.val;
				root = root.right;
				return r;
			}
		}
		throw new RuntimeException("tree is empty");
	}
}

/**
 * Your BSTIterator will be called like this: 
 * BSTIterator i = new BSTIterator(root); 
 * while (i.hasNext()) v[f()] = i.next();
 */
