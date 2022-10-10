import java.util.ArrayList;
import java.util.List;

public class DFSDetectCycleInDirectedGraph {
	List<ArrayList<Integer>> adjacencyList;
	int vertices;

	public DFSDetectCycleInDirectedGraph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new ArrayList<ArrayList<Integer>>(vertices);
		for (int i = 0; i < vertices; i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int u, int v) {
		adjacencyList.get(u).add(v);
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

	public boolean dfsContainsCycle(int source, boolean visited[], boolean[] recursionCallStack) {
		visited[source] = true;
		recursionCallStack[source] = true;
		for (int i : adjacencyList.get(source)) {
			if (!visited[i] && dfsContainsCycle(i, visited, recursionCallStack))
				return true;
			else if (recursionCallStack[i])
				return true;
		}

		recursionCallStack[source] = false;
		return false;
	}

	public boolean dfsUtil(int source) {
		boolean visited[] = new boolean[vertices];
		boolean recursionCallStack[] = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			if (!visited[i])
				if (dfsContainsCycle(i, visited, recursionCallStack))
					return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int v = 6;
		DFSDetectCycleInDirectedGraph graph = new DFSDetectCycleInDirectedGraph(v);
		graph.addEdge(0, 1);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 3);
		System.out.println(graph.dfsUtil(0));
	}

}
