package DS.Graphs;

/*
 * Note:
 * 1. When we are given a Adjacency Matrix as input, we can use this implementation of Dijkstra. 
 * 2. Time Complexity : O(V^2)
 * 3. Dijkstra Algorithm is used to find single source shortest path. 
 * 4. This implementation can be applied on directed as well as undirected graphs. 
 */

public class DijkstraAdjMatrix {
	static final int V = 9;
	
	private int minDistance(int[] dist,boolean[] sptSet) {
		int min = Integer.MAX_VALUE, min_index = -1;
		
		for(int v=0; v<V; v++) {
			if(sptSet[v]==false && dist[v]<=min) {
				min = dist[v];
				min_index=v;
			}
		}
		return min_index;
	}
	
	private void dijkstra(int[][] graph,int src)
	{
		int[] dist = new int[V];
		boolean[] sptSet = new boolean[V];
		
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		
		for(int count=0; count<V-1; count++) {
			int u = minDistance(dist,sptSet);
			sptSet[u]=true;
			
			for(int v=0; v<V; v++) {
				if(!sptSet[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
			}
		}
		print(dist);
	}
	
	void print(int[] dist) {
		System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
	}

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
						            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
						            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
						            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
						            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
						            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
						            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
						            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
						            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
						            
        DijkstraAdjMatrix d = new DijkstraAdjMatrix();
        d.dijkstra(graph, 0);
	}

}
