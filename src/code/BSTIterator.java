package code;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import test.TreeNode;

public class BSTIterator {
    private Stack<TreeNode> S;
    private Set<TreeNode> visited;
    
    public BSTIterator(TreeNode root) {
        this.S = new Stack<>();
        this.visited = new HashSet<>();
        if (root != null)
            S.push(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !S.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        while (!S.isEmpty()) {
            TreeNode node = S.pop();
            if (visited.contains(node))
                return node.val;
            visited.add(node);
            if (node.left == null) {
                if (node.right != null)
                    S.push(node.right);
                S.push(node);
                break;
            } else {
                if (node.right != null)
                    S.push(node.right);
                S.push(node);
                S.push(node.left);
            }
        }
        return S.pop().val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */