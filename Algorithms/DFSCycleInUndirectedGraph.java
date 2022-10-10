import java.util.ArrayList;
import java.util.List;

public class DFSCycleInUndirectedGraph {
	List<ArrayList<Integer>> adjacencyList;
	int vertices;

	public DFSCycleInUndirectedGraph(int vertices) {
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

	public boolean dfsContainsCycle(int source, boolean visited[], int parent) {
		visited[source] = true;
		for (int i : adjacencyList.get(source)) {
			if (!visited[i])
				return dfsContainsCycle(i, visited, source);
			else if (i != parent) {
				return true;
			}
		}
		return false;
	}

	public boolean dfsUtil(int source) {
		boolean visited[] = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			if (!visited[i])
				return dfsContainsCycle(i, visited, -1);
		}
		return false;
	}

	public static void main(String[] args) {
		int v = 4;
		DFSCycleInUndirectedGraph graph = new DFSCycleInUndirectedGraph(v);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		System.out.println(graph.dfsUtil(0));
	}

}
