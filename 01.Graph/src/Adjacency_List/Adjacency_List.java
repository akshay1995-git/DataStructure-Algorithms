package Adjacency_List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;



public class Adjacency_List {
	ArrayList<Graph_Node> nodeList = new ArrayList<>();

	public Adjacency_List(ArrayList<Graph_Node> nodeList) {
		this.nodeList = nodeList;
	}

	public void addUndirected_Edge(int i, int j) {
		Graph_Node first = nodeList.get(i);
		Graph_Node second = nodeList.get(j);
		first.neighbors.add(second);
		second.neighbors.add(first);
	}

	public void addDirected_Edge(int i, int j) {
		Graph_Node first = nodeList.get(i);
		Graph_Node second = nodeList.get(j);
		first.neighbors.add(second);

	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).name + ": ");
			for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
				if (j == nodeList.get(i).neighbors.size() - 1) {
					s.append((nodeList.get(i).neighbors.get(j).name));
				} else {
					s.append((nodeList.get(i).neighbors.get(j).name) + " --> ");
				}
			}
			s.append("\n");
		}
		return s.toString();
	}

	// BSF internall
	void bfsVisit(Graph_Node node) {
		LinkedList<Graph_Node> queue = new LinkedList<Graph_Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Graph_Node currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			for (Graph_Node neighbor : currentNode.neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
					System.out.print(" 1");
				}
			}
		}
	}
	//Time complexity  and space complexity of BFS---O(V+E) 
	void breadth_first_search() {

		for (Graph_Node node : nodeList) {
			if (!node.isVisited) {
				bfsVisit(node);
			}
		}
	}

	void dfsVisit(Graph_Node node) {
		Stack<Graph_Node> stack = new Stack<Graph_Node>();
		stack.push(node);//---------o(1)
		while (!stack.isEmpty()) {//-------------------------------------------o(v)
			Graph_Node currentNode = stack.pop();//------o(1)
			currentNode.isVisited = true;//---------o(1)
			System.out.print(currentNode.name + " ");
			for (Graph_Node neighbor : currentNode.neighbors) {//--------------o(adj)
				if (!neighbor.isVisited) {
					stack.push(neighbor);//-------o(1)
					neighbor.isVisited = true;

				}
			}
		}
	}
//Time complexity  and space complexity of DFS ---O(V+E) 
	void depth_first_search() {

		for (Graph_Node node : nodeList) {//------------o(v)
			if (!node.isVisited) {
				dfsVisit(node);
			}
		}
	}
//Topological sort in adj list
	public void topological_visit(Graph_Node node,Stack<Graph_Node> stack) {
		//Stack<GraphNode> stack=new Stack<GraphNode>();
		
		for(Graph_Node neighbor:node.neighbors) {
			if(!neighbor.isVisited) {
				topological_visit(neighbor,stack);
			}
		}
		node.isVisited=true;
		stack.push(node);
		
	}
	public void topological_sort() {
		Stack<Graph_Node> stack =new Stack<>();
		for(Graph_Node node:nodeList) {
			if(!node.isVisited) {
				topological_visit(node,stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().name+" --> ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Graph_Node> nodelist = new ArrayList<>();
		nodelist.add(new Graph_Node("A", 0));
		nodelist.add(new Graph_Node("B", 1));
		nodelist.add(new Graph_Node("C", 2));
		nodelist.add(new Graph_Node("D", 3));
		nodelist.add(new Graph_Node("E", 4));

		Adjacency_List obj = new Adjacency_List(nodelist);
		obj.addUndirected_Edge(0, 1);
		obj.addUndirected_Edge(0, 2);
		obj.addUndirected_Edge(0, 3);
		obj.addUndirected_Edge(1, 4);
		obj.addUndirected_Edge(2, 3);
		obj.addUndirected_Edge(3, 4);
		System.out.println("Unweighted -UnDirected Graph : \n" + obj.toString());
		System.out.println("BFS Travesal in List : ");
		obj.breadth_first_search();
		System.out.println("DFS Travesal in List : ");
		obj.depth_first_search();
		Adjacency_List obj1 = new Adjacency_List(nodelist);
		obj1.addDirected_Edge(0, 1);
		obj1.addDirected_Edge(0, 2);
		obj1.addDirected_Edge(0, 3);
		obj1.addDirected_Edge(1, 4);
		obj1.addDirected_Edge(2, 3);
		obj1.addDirected_Edge(3, 4);
		System.out.println("\nUnweighted -Directed Graph : \n" + obj1.toString());
		System.out.println("Topological Sort : ");
		obj1.topological_sort();
	}

}
