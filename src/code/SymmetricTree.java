package code;

import java.util.Stack;

import test.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        left.push(root);
        right.push(root);
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode leftNode = left.pop();
            TreeNode rightNode = right.pop();
            if (leftNode.val != rightNode.val)
                return false;
            if (leftNode.left != null && rightNode.right != null) {
                left.push(leftNode.left);
                right.push(rightNode.right);
            } else if (!(leftNode.left == null && rightNode.right == null))
                return false;
            if (leftNode.right != null && rightNode.left != null) {
                left.push(leftNode.right);
                right.push(rightNode.left);
            } else if (!(leftNode.right == null && rightNode.left == null))
                return false;
        }
        if (!(left.isEmpty() && right.isEmpty())) {
            return false;
        }
        return true;
    }
}
