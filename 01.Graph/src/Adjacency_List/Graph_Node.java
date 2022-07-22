package Adjacency_List;

import java.util.ArrayList;

public class Graph_Node {
String name;
int index;
boolean isVisited=true;

ArrayList<Graph_Node> neighbors=new ArrayList<Graph_Node>();
public Graph_Node(String name,int index) {
	this.name=name;
	this.index=index;
}
}
