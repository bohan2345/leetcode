package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DirectedGraph {
	public static class Vertex {
		public int label;
		Set<Edge> out;
		Set<Edge> in;

		public Vertex(int l) {
			this.label = l;
			this.out = new HashSet<>();
			this.in = new HashSet<>();
		}

		@Override
		public String toString() {
			return Integer.toString(this.label);
		}
	}

	public static class Edge {
		public Vertex from;
		public Vertex to;
		public int weight;

		public Edge(Vertex from, Vertex to) {
			this.from = from;
			this.to = to;
			this.weight = 1;
		}

		public Edge(Vertex from, Vertex to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return from.toString() + " --> " + Integer.toString(weight) + " --> " + to.toString();
		}

		@Override
		public int hashCode() {
			return this.from.hashCode() + this.to.hashCode();
		}

		@Override
		public boolean equals(Object o) {
			Edge e = (Edge) o;
			if (this.from.equals(e.from) && this.to.equals(e.to) && this.weight == e.weight)
				return true;
			else
				return false;
		}
	}

	Set<Vertex> V;
	Set<Edge> E;

	public DirectedGraph() {
		this.V = new HashSet<Vertex>();
		this.E = new HashSet<Edge>();
	}

	public boolean addVertex(Vertex v) {
		if (V.contains(v))
			return false;
		V.add(v);
		return true;
	}

	public boolean addDAGEdge(Vertex from, Vertex to) {
		Edge e = new Edge(from, to);
		if (E.contains(e)) {
			return false;
		}
		this.E.add(e);
		from.out.add(e);
		to.in.add(e);
		if (topologicalOrder() != null) {
			return true;
		} else {
			this.E.remove(e);
			from.out.remove(e);
			to.in.remove(e);
			return false;
		}
	}

	public boolean addEdge(Vertex from, Vertex to) {
		Edge e = new Edge(from, to);
		if (E.contains(e))
			return false;
		this.E.add(e);
		from.out.add(e);
		to.in.add(e);
		return true;
	}

	public Set<Edge> incomingEdgeOf(Vertex v) {
		return v.in;
	}

	public Set<Edge> outgoingEdgeOf(Vertex v) {
		return v.out;
	}

	public int inDegreeOf(Vertex v) {
		return v.in.size();
	}

	public int outDegreeOf(Vertex v) {
		return v.out.size();
	}

	public boolean removeVertex(Vertex v) {
		if (!V.contains(v))
			return false;
		this.V.remove(v);
		Set<Edge> needRemove = new HashSet<>();
		for (Edge e : this.E) {
			if (e.from.equals(v)) {
				needRemove.add(e);
				e.to.in.remove(e);
			} else if (e.to.equals(v)) {
				needRemove.add(e);
				e.from.out.remove(e);
			}
		}
		this.E.removeAll(needRemove);
		return true;
	}

	public List<Vertex> topologicalOrder() {
		DirectedGraph DAGBackup = this.clone();
		List<Vertex> res = new ArrayList<>();
		int d = 0;
		while (!DAGBackup.V.isEmpty() && d != DAGBackup.V.size()) {
			d = DAGBackup.V.size();
			Set<Vertex> needRemove = new HashSet<>();
			for (Vertex v : DAGBackup.V) {
				if (inDegreeOf(v) == 0) {
					needRemove.add(v);
				}
			}
			res.addAll(needRemove);
			for (Vertex v : needRemove) {
				DAGBackup.removeVertex(v);
			}
		}
		if (res.size() == this.V.size())
			return res;
		else
			return null;
	}

	@Override
	public DirectedGraph clone() {
		DirectedGraph newDGA = new DirectedGraph();
		Map<Vertex, Vertex> table = new HashMap<>();
		for (Vertex v : this.V) {
			Vertex newVertex = new Vertex(v.label);
			newDGA.V.add(newVertex);
			table.put(v, newVertex);
		}
		for (Edge e : this.E) {
			newDGA.addEdge(table.get(e.from), table.get(e.to));
		}
		return newDGA;
	}
}