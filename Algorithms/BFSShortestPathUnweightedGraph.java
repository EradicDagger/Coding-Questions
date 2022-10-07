import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSShortestPathUnweightedGraph {
	List<ArrayList<Integer>> adjacencyList;
	int vertices;

	public BFSShortestPathUnweightedGraph(int vertices) {
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

	public void bfs(int source) {
		boolean visited[] = new boolean[vertices];
		int distance[] = new int[vertices];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		visited[source] = true;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (Integer i : adjacencyList.get(current)) {
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
					distance[i] = distance[current] + 1;
				}
			}
		}
		for (int i : distance)
			System.out.println(i);
	}

	public static void main(String[] args) {
		int v = 4;
		BFSShortestPathUnweightedGraph graph = new BFSShortestPathUnweightedGraph(v);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.bfs(0);
	}

}
