package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import test.TreeNode;

public class LevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> levels = new ArrayList<List<Integer>>();

		if (root != null) {
			Queue<TreeNode> nodes = new LinkedList<TreeNode>();
			List<Integer> vals = new ArrayList<Integer>();
			int currentlevel = 0, next = 0;
			nodes.add(root);
			currentlevel++;
			TreeNode node;
			while ((node = nodes.poll()) != null) {
				currentlevel--;
				vals.add(node.val);
				if (node.left != null) {
					nodes.add(node.left);
					next++;
				}
				if (node.right != null) {
					nodes.add(node.right);
					next++;
				}
				if (currentlevel == 0) {
					levels.add(0,vals);
					vals = new ArrayList<Integer>();
					currentlevel = next;
					next = 0;
				}
			}
			if (vals.size() > 0)
				levels.add(0,vals);
		}
		
		return levels;
	}
}
