package code;

import java.util.LinkedList;
import java.util.Queue;

import test.TreeLinkNode;

public class NextRightNode {
	public void connect(TreeLinkNode root) {
		if (root==null){
			return;
		} 
		Queue<TreeLinkNode> nodes = new LinkedList<TreeLinkNode>();
		int current = 0, next = 0;
		nodes.add(root);
		current++;
		while (nodes.size() > 0) {
			TreeLinkNode node = nodes.poll();
			current--;
			if (node.left != null) {
				nodes.add(node.left);
				next++;
			}
			if (node.right != null) {
				nodes.add(node.right);
				next++;
			}
			if (current == 0) {
				current = next;
				next = 0;
				node.next = null;
			}else{
				node.next = nodes.peek();
			}
		}
	}
}
