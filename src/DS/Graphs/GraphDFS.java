package DS.Graphs;

import java.util.LinkedList;

public class GraphDFS {

	int V; 
	LinkedList<Integer> adj[];
	
	GraphDFS(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void dfs(int s) {
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; i++) {
			if(!visited[i]) 
			dfs_util(s,visited);
		}	
	}
	
	void dfs_util(int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(s+" ");
		
		LinkedList<Integer> neighbours = adj[s];
		for(Integer n : neighbours) {
			if(!visited[n]) {
				dfs_util(n,visited);
			}
		}
	}
	
	public static void main(String[] args) {
		GraphDFS g = new GraphDFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.dfs(0);
	}

}
