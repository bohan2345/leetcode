package code;

import test.TreeNode;

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        int[] sum = {0};
        dfs(root, sum, 0);
        return sum[0];
    }
    
    void dfs(TreeNode root, int[] sum, int tmp) {
        if (root == null)
            return;
        tmp = tmp * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum[0] = sum[0] + tmp;
        }
        dfs(root.left, sum, tmp);
        dfs(root.right, sum, tmp);
    }
}