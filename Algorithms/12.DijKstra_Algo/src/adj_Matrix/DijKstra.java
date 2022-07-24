package adj_Matrix;
/*DijKstra Algorithms :
 Dijkstra’s algorithm is used to find the shortest distance from the source node to all the other nodes in the graph.
 As a result of the running Dijkstra’s algorithm on a graph, we obtain the shortest path tree (SPT) with the source vertex as root.
 In Dijkstra’s algorithm, we maintain two sets or lists. One contains the vertices that are a part of the shortest-path tree (SPT) 
 and the other contains vertices that are being evaluated to be included in SPT. Hence for every iteration, we find a vertex from
 the second list that has the shortest path.
 */
class DijKstra {

	static final int num_Vertices = 5; // max number of vertices in graph
	// find a vertex with minimum distance

	int minDistance(int path_array[], Boolean sptSet[]) {//0,i,i,i,i // t,f,f,f,f
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < num_Vertices; v++)
			if (sptSet[v] == false && path_array[v] <= min) {//(false==flase && 
				min = path_array[v];
				min_index = v;
			}
		return min_index;
	}

	// print the array of distances (path_array)
	void printMinpath(int path_array[]) {
		System.out.println("Vertex# \t Minimum Distance from Source");
		for (int i = 0; i < num_Vertices; i++)
			System.out.println(i + " \t\t\t " + path_array[i]);
	}

// Implementation of Dijkstra's algorithm for graph (adjacency matrix) 
	void algo_dijkstra(int graph[][], int src_node) { // graph,0
		int path_array[] = new int[num_Vertices]; // The output array. dist[i] will hold
		// the shortest distance from src to i

		// spt (shortest path set) contains vertices that have shortest path
		Boolean sptSet[] = new Boolean[num_Vertices];

		// Initially all the distances are INFINITE and stpSet[] is set to false
		for (int i = 0; i < num_Vertices; i++) {
			path_array[i] = Integer.MAX_VALUE; // initially all vertices distance is infinite from source
			sptSet[i] = false; // and all vertices are unvisited
		}
		// Path between vertex and itself is always 0
		path_array[src_node] = 0; // set start vertices with 0 distance from itself
		// now find shortest path for all vertices
		for (int count = 0; count < num_Vertices - 1; count++) {
			// call minDistance method to find the vertex with min distance
			int u = minDistance(path_array, sptSet);
			// the current vertex u is processed
			sptSet[u] = true;
			// process adjacent nodes of the current vertex
			for (int v = 0; v < num_Vertices; v++)
				// if vertex v not in sptset then update it
				if (!sptSet[v] && graph[u][v] != 0 && path_array[u] != Integer.MAX_VALUE
						&& path_array[u] + graph[u][v] < path_array[v]) {
					path_array[v] = path_array[u] + graph[u][v]; //set min distance to that vertices
				}
		}
		

		// print the path array
		printMinpath(path_array);

	}

	public static void main(String[] args) {
		// example graph is given below
		int graph[][] = new int[][] { { 0, 4, 0, 0, 7 }, { 4, 0, 1, 2, 0 }, { 0, 1, 0, 6, 0 }, { 0, 2, 6, 0, 0 },
				{ 7, 0, 0, 0, 0 } };
		DijKstra g = new DijKstra();
		g.algo_dijkstra(graph, 0);
	}
}