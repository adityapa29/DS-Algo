package DS.Graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class GraphBFS {
	
	int V;
	LinkedList<Integer>[] adj;
	
	
	public GraphBFS(int v) {
		V=v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	private void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public void BFS(int s) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[V];
		
		queue.offer(s);
		visited[s] = true;
		
		while(!queue.isEmpty())
		{
			s = queue.poll();
			System.out.print(s+" ");
			
			for(int i=0; i<adj[s].size(); i++) {
				int curr = adj[s].get(i);
				
				if(!visited[curr]) {
					queue.offer(curr);
					visited[curr] = true;
				}
			}
		}
		System.out.println();
		System.out.println("Adjacency List: ");
		System.out.println(Arrays.toString(adj));
		
	}

	public static void main(String[] args) {
		GraphBFS g = new GraphBFS(4);
		
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.BFS(2);

	}

}
