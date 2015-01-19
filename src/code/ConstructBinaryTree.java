package code;

import test.TreeNode;

public class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    TreeNode build(int[] preorder, int preleft, int preright, int[] inorder, int inleft, int inright) {
        if (preleft > preright)
            return null;
        TreeNode root = new TreeNode(preorder[preleft]);
        int i = inleft;
        for (; i <= inright; i++) {
            if (inorder[i] == preorder[preleft])
                break;
        }
        root.left = build(preorder, preleft + 1, preleft + i - inleft, inorder, inleft, i - 1);
        root.right = build(preorder, preleft + i - inleft + 1, preright, inorder, i + 1, inright);
        return root;
    }
}