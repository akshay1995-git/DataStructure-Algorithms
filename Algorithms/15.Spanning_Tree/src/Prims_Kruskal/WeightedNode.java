package Prims_Kruskal;

import java.util.*;

public class WeightedNode implements Comparable<WeightedNode> {
  public String name;
  public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
  public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
  public boolean isVisited = false;
  public WeightedNode parent;
  public int distance;
  public int index;
  public DisjointSet set;


  public WeightedNode(String name) {
    this.name = name;
    
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int compareTo(WeightedNode o) {
    return this.distance - o.distance;
  }


}
