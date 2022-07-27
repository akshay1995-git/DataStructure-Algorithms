package Prims_algo;

public class Prims_Algorithm {
	int vertex;
	public static final int I = 999;

	public Prims_Algorithm(int vertex) {
		this.vertex = vertex;
	}

	public int minIndex(int[] key, Boolean[] isVisited) {
		int min = I;
		int min_index = -1;
		for (int i = 0; i < vertex; i++) {
			if (min > key[i] && isVisited[i] == false) {
				min = key[i];
				min_index = i;
			}
		}
		return min_index;
	}

	public void pathPrint(int[] parent, int[][] graph) {
		int sum = 0;
		for (int i = 1; i < vertex; i++) {
			System.out.println(parent[i] + "  -  " + i + " \t " + graph[i][parent[i]]);
			sum += graph[i][parent[i]];
		}
		System.out.println("Minimun Span To visit all vertex : " + sum);
	}

	public void algo_prims(int[][] graph, int source) {
		int[] parent = new int[vertex];//array used to store constructed MST
		int[] key = new int[vertex];//used to pick minimum weight
		Boolean[] isVisited = new Boolean[vertex];//to represent set of vertices visited or not
		for (int i = 0; i < vertex; i++) {
			key[i] = I;//initialize all key 
			isVisited[i] = false;//initialize all vertices unvisited
		}
		key[source] = 0;
		parent[source]=-1;

		
		for (int count = 0;count < vertex-1;count++) {
			int u = minIndex(key, isVisited);//find the min weight at strt
			isVisited[u] = true;//mark rthat vertices is visited

			for (int v = 0; v < vertex; v++) {

				if (graph[u][v] != 0 && isVisited[v] != true && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];

				}
				//System.out.println(key[v]);
			}
			
		}
		pathPrint(parent, graph);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };
		Prims_Algorithm obj = new Prims_Algorithm(5);
		obj.algo_prims(graph, 0);
	}

}
