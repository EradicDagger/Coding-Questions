import java.util.ArrayList;
import java.util.List;

public class DFSDisconnectedGraph {
	List<ArrayList<Integer>> adjacencyList;
	int vertices;

	public DFSDisconnectedGraph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new ArrayList<ArrayList<Integer>>(vertices);
		for (int i = 0; i < 5; i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int u, int v) {
		adjacencyList.get(u).add(v);
		adjacencyList.get(v).add(u);
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

	public void dfs(int source, boolean visited[]) {
		visited[source] = true;
		System.out.println(source);
		for (int i : adjacencyList.get(source)) {
			if (!visited[i])
				dfs(i, visited);
		}
	}

	public void dfsUtil(int source) {
		boolean visited[] = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			if (!visited[i])
				dfs(i, visited);
		}
	}

	public static void main(String[] args) {
		int v = 5;
		DFSDisconnectedGraph graph = new DFSDisconnectedGraph(v);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.printGraph();
		graph.dfsUtil(0);
	}

}
