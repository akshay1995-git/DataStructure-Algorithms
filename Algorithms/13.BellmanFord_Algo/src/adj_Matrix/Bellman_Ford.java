package adj_Matrix;
/*
 Bellman-Ford Algo:
 This algorithm overcome disadvantage of dijkstra algo. as dijkstra does not support negative 
 weighted graph but bellman support that
 
 */
public class Bellman_Ford {
	
	int minDistance(int path_array[], Boolean sptSet[]) {// 0,i,i,i,i // t,f,f,f,f
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < path_array.length; v++)
			if (sptSet[v] == false && path_array[v] <= min) {// (false==flase &&
				min = path_array[v];
				min_index = v;
			}
		return min_index;
	}

	// print the array of distances (path_array)
	void printMinpath(int path_array[]) {
		System.out.println("Vertex# \t Minimum Distance from Source");
		for (int i = 0; i < path_array.length; i++)
			System.out.println(i + " \t\t\t " + path_array[i]);
	}

	public void algo_bellman(int[][] graph, int source) {
		int path_array[] = new int[graph.length];
		Boolean[] check_pt = new Boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			path_array[i] = Integer.MAX_VALUE;
			check_pt[i] = false;
		}
		path_array[source] = 0;// set source point 0 from itself
		for (int temp = 0; temp < path_array.length; temp++) {
			int u = minDistance(path_array, check_pt);// find min vertex from all other vertex
			check_pt[u] = true;// mark source vertex visited

			for (int v = 0; v < path_array.length; v++) {
				if (!check_pt[v] && graph[u][v] != 0 && path_array[u] != Integer.MAX_VALUE
						&& path_array[u] + graph[u][v] < path_array[v]) {
					path_array[v] = path_array[u] + graph[u][v]; // set min distance to that vertices
				}

			}
		}
		for (int sourcenode=0;sourcenode<path_array.length;sourcenode++) {
			
			for(int destinationnode=0;destinationnode<path_array.length;destinationnode++) {
				if (graph[sourcenode][destinationnode] != Integer.MAX_VALUE
						&& path_array[destinationnode] > path_array[sourcenode]
		                           + graph[sourcenode][destinationnode])
                {
     
                        System.out.println("The Graph contains negative egde cycle");
                }
				
			}
		}
		printMinpath(path_array);
	}

	
	public static void main(String[] args) {
		int graph[][] = new int[][] { {0,  4,  0,  0,  -1},{0,  0,  -1,  0,  -2},{0, 0,  0,  0,  0},{0 ,0 , 0 , 0 , 0},{0,0,0,-5,0}};
		Bellman_Ford obj = new Bellman_Ford();
		obj.algo_bellman(graph, 0);

	}
}
