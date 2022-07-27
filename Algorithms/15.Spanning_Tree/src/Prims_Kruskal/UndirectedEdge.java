package Prims_Kruskal;

public class UndirectedEdge {
public WeightedNode first;
public WeightedNode second;
public int weight;
	public UndirectedEdge(WeightedNode first,WeightedNode second,int weight) {
		// TODO Auto-generated constructor stub
		this.first=first;
		this.second=second;
		this.weight=weight;
	}
	@Override
	public String toString() {
		return "UndirectedEdge [first=" + first + ", second=" + second + ", weight=" + weight + "]";
	}

}
