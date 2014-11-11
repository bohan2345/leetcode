package code;

import java.util.ArrayList;
import java.util.List;

import test.TreeNode;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
        if (root == null) 
            return 0;
        List<Integer> max = new ArrayList<>();
        max.add(root.val);
        dfs(root, max);
        return max.get(0);
    }
    
    private int dfs(TreeNode root, List<Integer> max) {
        if(root == null)
            return 0;
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        if (max.get(0) < left + right + root.val) {
            max.remove(0);
            max.add(left + right + root.val);
        }
        return Math.max(left, right) + root.val;
    }
}
