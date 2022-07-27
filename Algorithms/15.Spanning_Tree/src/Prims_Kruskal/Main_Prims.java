package Prims_Kruskal;

import java.util.ArrayList;

public class Main_Prims {

	public static void main(String[] args) {
		ArrayList<WeightedNode> nodelist=new ArrayList<>();
		nodelist.add(new WeightedNode("A"));
		nodelist.add(new WeightedNode("B"));
		nodelist.add(new WeightedNode("C"));
		nodelist.add(new WeightedNode("D"));
		nodelist.add(new WeightedNode("E"));
		Prims graph =new Prims(nodelist);
		graph.addWeightedUndirectedEdge(0,1, 5);
		graph.addWeightedUndirectedEdge(0,2, 13);
		graph.addWeightedUndirectedEdge(0,4, 15);
		graph.addWeightedUndirectedEdge(1,2, 10);
		graph.addWeightedUndirectedEdge(1,3, 8);
		graph.addWeightedUndirectedEdge(2,3, 6);
		graph.addWeightedUndirectedEdge(2,4, 20);
		System.out.println("Prims  AlGorithm : ");
		graph.prims(nodelist.get(0));

	}

}
