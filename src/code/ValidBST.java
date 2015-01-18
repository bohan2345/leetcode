package code;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import test.TreeNode;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> S = new Stack<>();
        S.push(root);
        Set<TreeNode> isVisited = new HashSet<>();
        int lastVal = Integer.MIN_VALUE;
        boolean first = true;
        while (!S.isEmpty()) {
            TreeNode node = S.pop();
            if (isVisited.contains(node)) {
                if (lastVal >= node.val && !first)
                    return false;
                first = false;
                lastVal = node.val;
                continue;
            }
            isVisited.add(node);
            if (node.right != null)
                S.push(node.right);
            S.push(node);
            if (node.left != null)
                S.push(node.left);
        }
        return true;
    }
}
