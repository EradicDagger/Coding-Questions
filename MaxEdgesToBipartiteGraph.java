// Java code to print maximum edges such that 
// Tree remains a Bipartite graph 
import java.util.*; 

class GFG 
{ 

// To store counts of nodes with two colors 
static long []count_color = new long[2]; 

static void dfs(Vector<Integer> adj[], int node, 
					int parent, boolean color) 
{ 
	// Increment count of nodes with current 
	// color 
	count_color[color == false ? 0 : 1]++; 

	// Traversing adjacent nodes 
	for (int i = 0; i < adj[node].size(); i++) 
	{ 

		// Not recurring for the parent node 
		if (adj[node].get(i) != parent) 
			dfs(adj, adj[node].get(i), node, !color); 
	} 
} 

// Finds maximum number of edges that can be added 
// without violating Bipartite property. 
static int findMaxEdges(Vector<Integer> adj[], int n) 
{ 
	// Do a DFS to count number of nodes 
	// of each color 
	dfs(adj, 1, 0, false); 

	return (int) (count_color[0] * 
				count_color[1] - (n - 1)); 
} 

// Driver code 
public static void main(String[] args) 
{ 
	int n = 5; 
	Vector<Integer>[] adj = new Vector[n + 1]; 
	for (int i = 0; i < n + 1; i++) 
		adj[i] = new Vector<Integer>(); 
	
	adj[1].add(2); 
	adj[1].add(3); 
	adj[2].add(4); 
	adj[3].add(5); 
	System.out.println(findMaxEdges(adj, n)); 
} 
} 
