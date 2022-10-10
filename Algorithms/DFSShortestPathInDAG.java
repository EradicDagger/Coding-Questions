import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
	int vertex;
	int weight;

	public Node(int vertex, int weight) {
		super();
		this.vertex = vertex;
		this.weight = weight;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}

public class DFSShortestPathInDAG {
	List<ArrayList<Node>> adjacencyList;
	int vertices;

	public DFSShortestPathInDAG(int vertices) {
		this.vertices = vertices;
		adjacencyList = new ArrayList<ArrayList<Node>>(vertices);
		for (int i = 0; i < vertices; i++) {
			adjacencyList.add(new ArrayList<Node>());
		}
	}

	public void addEdge(int u, int v, int w) {
		adjacencyList.get(u).add(new Node(v, w));
	}

	public void printGraph() {
		for (int i = 0; i < adjacencyList.size(); i++) {
			System.out.print(i + " -> ");
			for (int j = 0; j < adjacencyList.get(i).size(); j++) {
				System.out.print(adjacencyList.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public void dfs(int source, boolean visited[], Stack<Integer> stack) {
		visited[source] = true;
		for (Node i : adjacencyList.get(source)) {
			if (!visited[i.getVertex()])
				dfs(i.getVertex(), visited, stack);
		}
		stack.push(source);
	}

	public void dfsUtil(int source) {
		boolean visited[] = new boolean[vertices];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < vertices; i++) {
			if (!visited[i])
				dfs(i, visited, stack);
		}

		int distance[] = new int[vertices];
		for (int i = 0; i < vertices; i++)
			distance[i] = Integer.MAX_VALUE;

		distance[source] = 0;

		while (!stack.isEmpty()) {
			int element = (stack.pop());
			if (distance[element] != Integer.MAX_VALUE)
				for (Node i : adjacencyList.get(element)) {
					if (distance[i.getVertex()] > distance[element] + i.getWeight()) {
						distance[i.getVertex()] = distance[element] + i.getWeight();
					}
				}
		}

		for (int i : distance) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		int v = 4;
		DFSShortestPathInDAG g = new DFSShortestPathInDAG(v);
		g.addEdge(0, 3, 5);
		g.addEdge(0, 2, 10);
		g.addEdge(0, 1, 9);
		g.addEdge(1, 2, 8);
		g.addEdge(2, 3, 7);
		g.dfsUtil(0);
	}

}
