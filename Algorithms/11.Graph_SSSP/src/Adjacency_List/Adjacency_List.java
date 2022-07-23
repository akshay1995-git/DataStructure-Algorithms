package Adjacency_List;

import java.util.ArrayList;
import java.util.LinkedList;

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

//*SINGLE SOURCE SHORTEST PATH 
	public static void pathPrint(Graph_Node node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name);
	}
	//* 1]-by Breadth First Search
	public void ssspVisit_by_BFS(Graph_Node node) {
		LinkedList<Graph_Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Graph_Node currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print("Printing path for node " + currentNode.name + ": ");
			pathPrint(currentNode);
			System.out.println();
			for (Graph_Node neighbor : currentNode.neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
					neighbor.parent = currentNode;
				}
			}

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
		obj.ssspVisit_by_BFS(nodelist.get(0));

	}

}
