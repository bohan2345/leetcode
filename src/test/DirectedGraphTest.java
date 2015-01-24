package test;

import java.util.List;

import code.DirectedGraph;
import code.DirectedGraph.Vertex;

public class DirectedGraphTest {
	public static void main(String[] args) {
		DirectedGraph DAG = new DirectedGraph();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		DAG.addVertex(v1);
		DAG.addVertex(v2);
		DAG.addVertex(v3);
		DAG.addVertex(v4);
		DAG.addVertex(v5);

		DAG.addEdge(v1, v2);
		DAG.addEdge(v2, v3);
		DAG.addEdge(v3, v4);
		DAG.addEdge(v4, v5);
		// DAG.addEdge(v5, v1);
		boolean b = DAG.addDAGEdge(v5, v1);
		System.out.println(b);
		// DirectedGraph newDAG = DAG.clone();
		// newDAG.addEdge(v3, v1);
		// v1.label = 4;
		// System.out.println();

		// DAG.addDAGEdge(v1, v2);
		//
		// int i1 = DAG.inDegreeOf(v1);
		// int i2 = DAG.inDegreeOf(v2);
		//
		// System.out.println(i1);
		// System.out.println(i2);
		//
		// DAG.addDAGEdge(v2, v3);
		// DAG.addDAGEdge(v3, v4);
		// DAG.addDAGEdge(v4, v5);
		// DAG.addDAGEdge(v5, v3);
		//
		// DAG.removeVertex(v5);
		List<Vertex> v = DAG.topologicalOrder();
		System.out.println(v);
	}
}
