import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSKahnsAlgorithmDetectCycleInDirectedGraph {
	List<ArrayList<Integer>> adjacencyList;
	int vertices;

	public BFSKahnsAlgorithmDetectCycleInDirectedGraph(int vertices) {
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

	public void topologicalSortBFS(boolean visited[], int[] in_degree) {
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < vertices; i++) {
			if (in_degree[i] == 0) {
				queue.add(i);
				visited[i] = true;
			}
		}
		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);
			for (Integer i : adjacencyList.get(current)) {
				in_degree[i]--;
				if (in_degree[i] == 0) {
					queue.add(i);
					visited[i] = true;
				}
			}
			count++;
		}
		if (count != vertices)
			System.out.println("contains cycle");
	}

	public void topologicalSortBFSUtil() {
		int in_degree[] = new int[vertices];
		boolean visited[] = new boolean[vertices];
		populateInDegree(in_degree);
		topologicalSortBFS(visited, in_degree);
	}

	private void populateInDegree(int[] in_degree) {
		for (int i = 0; i < adjacencyList.size(); i++) {
			for (int j = 0; j < adjacencyList.get(i).size(); j++) {
				in_degree[adjacencyList.get(i).get(j)]++;
			}
		}
	}

	public static void main(String[] args) {
		int v = 5;
		BFSKahnsAlgorithmDetectCycleInDirectedGraph graph = new BFSKahnsAlgorithmDetectCycleInDirectedGraph(v);
		graph.addEdge(0, 1);
		graph.addEdge(4, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.topologicalSortBFSUtil();
	}

}
