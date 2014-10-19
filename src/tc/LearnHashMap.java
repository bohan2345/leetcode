package tc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import test.TreeNode;

public class LearnHashMap extends StaticTest {
	String name = "subClass name!";

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> results = new ArrayList<>();
		if (root == null) {
			return results;
		}
		Stack<TreeNode> Q = new Stack<>();
		Q.push(root);
		Set<TreeNode> visited = new HashSet<>();
		while (!Q.isEmpty()) {
			TreeNode node = Q.pop();
			if (visited.contains(node)) {
				results.add(node.val);
				continue;
			}
			if (node.right != null) {
				Q.push(node.right);
			}
			if (node.left == null) {
				results.add(node.val);
			} else {
				Q.push(node.left);
				Q.push(node);
			}
			visited.add(node);
		}
		return results;
	}

	public static void main(String[] args) {
		System.out.println(new LearnHashMap().name);
		System.out.println(new LearnHashMap().getName());
	}
}
