package Adjacency_Matrix;

import java.util.ArrayList;
import java.util.LinkedList;



public class Adjacency_Main {
	ArrayList<GraphNode> nodelist = new ArrayList<>();
	int[][] adj_matrix;

	Adjacency_Main(ArrayList<GraphNode> nodelist) {
		this.nodelist = nodelist;
		this.adj_matrix = new int[nodelist.size()][nodelist.size()];
	}

//add for unweighted undirected graph
	public void addUndirected_Edge(int i, int j) {
		adj_matrix[i][j] = 1;//   i    j
		adj_matrix[j][i] = 1;// i 0   1 //(i----j)A------B
	}                                    // j 1     0
//add for unweighted -Directed graph
	public void addDirected_Edge(int i, int j) {
		adj_matrix[i][j] = 1;//   i    j
		
	}    

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("   ");
		for (int i = 0; i < nodelist.size(); i++) {
			s.append(nodelist.get(i).name + " ");
		}
		s.append("\n");
		for (int i = 0; i < nodelist.size(); i++) {
			s.append(nodelist.get(i).name + ": ");
			for (int j : adj_matrix[i]) {
				s.append((j) + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}

// get Neighbors
	public ArrayList<GraphNode> getNeighbors(GraphNode node) {
		ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
		int nodeIndex = node.index;
		for (int i = 0; i < adj_matrix.length; i++) {
			if (adj_matrix[nodeIndex][i] == 1) {// condition to get neighbors
				neighbors.add(nodelist.get(i));
			}
		}
		return neighbors;

	}


//SINGLE SOURCE SHORTEST PATH 
/* Time Complexity -O(E) 
 * Space Complexity-O(V)
 * Algorithms 
 Enqueue any starting vertex
 while(queue is not empty)
 p=dequeing que element
 if p is unvisited mark it as visited
 enqueing all neighbors in queue of p
 update parent of adj vertices
 */
	// Print path of each of the vertex from source
	public static void pathPrint(GraphNode node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
	}
//* 1]-by Breadth First Search: can only use when graph is unweighted
	//not showing shortest path in case of weighted graph
	public void sssp_by_BFS(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print("Printing SSS path for node " + currentNode.name + ": ");
			pathPrint(currentNode);
			System.out.println();
			ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
			for (GraphNode neighbor : neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
					neighbor.parent = currentNode;
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<GraphNode> nodelist = new ArrayList<>();
		nodelist.add(new GraphNode("A", 0));
		nodelist.add(new GraphNode("B", 1));
		nodelist.add(new GraphNode("C", 2));
		nodelist.add(new GraphNode("D", 3));
		nodelist.add(new GraphNode("E", 4));

		Adjacency_Main obj = new Adjacency_Main(nodelist);
		obj.addUndirected_Edge(0, 1);
		obj.addUndirected_Edge(0, 2);
		obj.addUndirected_Edge(0, 3);
		obj.addUndirected_Edge(1, 4);
		obj.addUndirected_Edge(2, 3);
		obj.addUndirected_Edge(3, 4);
		System.out.println("Unweighted -UnDirected Graph : \n" + obj.toString());
		System.out.println("Single source shortest path for UnDirected -UnWeighted Graph: ");
		obj.sssp_by_BFS(nodelist.get(0));
		Adjacency_Main obj1 = new Adjacency_Main(nodelist);

		obj1.addDirected_Edge(0, 1);
		obj1.addDirected_Edge(0, 2);
		obj1.addDirected_Edge(0, 3);
		obj1.addDirected_Edge(1, 4);
		obj1.addDirected_Edge(2, 3);
		obj1.addDirected_Edge(3, 4);
		
		System.out.println("Unweighted - Directed Graph : \n" + obj1.toString());
		System.out.println("Single source shortest path for Directed -UnWeighted Graph: ");
		obj1.sssp_by_BFS(nodelist.get(0));
	}
}
