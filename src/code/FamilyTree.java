package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FamilyTree {
	static class FamilyTreeNode {
		int val;
		List<FamilyTreeNode> parents;
		List<FamilyTreeNode> children;

		public FamilyTreeNode(int val) {
			this.val = val;
			this.parents = new ArrayList<FamilyTreeNode>();
			this.children = new ArrayList<FamilyTreeNode>();
		}
	}

	public boolean hasCommonAncestor(FamilyTreeNode node1, FamilyTreeNode node2) {
		Set<FamilyTreeNode> S = new HashSet<>();
		Queue<FamilyTreeNode> Q = new LinkedList<>();
		Q.offer(node1);
		while (!Q.isEmpty()) {
			FamilyTreeNode node = Q.poll();
			if (S.contains(node))
				continue;
			S.add(node);
			for (FamilyTreeNode n : node.parents)
				Q.offer(n);
		}
		Q.offer(node2);
		Set<FamilyTreeNode> S2 = new HashSet<>();
		while (!Q.isEmpty()) {
			FamilyTreeNode node = Q.poll();
			if (S.contains(node))
				return true;
			if (S2.contains(node))
				continue;
			S2.add(node);
			for (FamilyTreeNode n : node.parents)
				Q.offer(n);
		}
		return false;
	}

	public static void main(String[] args) {
		FamilyTreeNode n1 = new FamilyTreeNode(1);
		FamilyTreeNode n2 = new FamilyTreeNode(2);
		FamilyTreeNode n3 = new FamilyTreeNode(3);
		FamilyTreeNode n4 = new FamilyTreeNode(4);
		FamilyTreeNode n5 = new FamilyTreeNode(5);
		FamilyTreeNode n6 = new FamilyTreeNode(6);
		FamilyTreeNode n7 = new FamilyTreeNode(7);
		FamilyTreeNode n8 = new FamilyTreeNode(8);
		FamilyTreeNode n9 = new FamilyTreeNode(9);
		n1.children.add(n3);
		n2.children.add(n3);
		n3.parents.add(n1);
		n3.parents.add(n2);
		n8.parents.add(n3);
		n9.parents.add(n8);
		n5.parents.add(n3);
		n5.parents.add(n4);
		n7.parents.add(n5);
		n7.parents.add(n6);
		boolean b = new FamilyTree().hasCommonAncestor(n4, n8);
		System.out.println(b);
	}
}
