package Adjacency_Matrix;

public class GraphNode {
String name;
int index;
boolean isVisited=false;
GraphNode parent;
public GraphNode(String nm,int ind) {
	name=nm;
	index=ind;
}
}
