package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CloneGraph {
	/**
	 * Definition for undirected graph.
	 */
	  class UndirectedGraphNode {
	      int label;
	      List<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	  };
	 
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		Stack<UndirectedGraphNode> S = new Stack<>();
		S.push(node);
		Map<UndirectedGraphNode, UndirectedGraphNode> table = new HashMap<>();
		table.put(node, newNode);
		Set<UndirectedGraphNode> visited = new HashSet<>();
		while (!S.isEmpty()) {
			UndirectedGraphNode n = S.pop();
			if (visited.contains(n)) {
			    continue;
			}
			visited.add(n);
			UndirectedGraphNode nn = null;
			if (table.containsKey(n))
				nn = table.get(n);
			else {
				nn = new UndirectedGraphNode(n.label);
				table.put(n, nn);
			}

			nn.neighbors = new ArrayList<>();
			for (UndirectedGraphNode adj : n.neighbors) {
				S.push(adj);
				if (table.containsKey(adj)) {
					nn.neighbors.add(table.get(adj));
				} else {
					UndirectedGraphNode newAdj = new UndirectedGraphNode(adj.label);
					table.put(adj, newAdj);
					nn.neighbors.add(newAdj);
				}
			}
		}
		return newNode;
	}
}
