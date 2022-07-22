package Adjacency_Matrix;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
public class Adjacency_Main {
ArrayList<GraphNode> nodelist=new ArrayList<>();
int [][] adj_matrix;
Adjacency_Main(ArrayList<GraphNode> nodelist){
	this.nodelist=nodelist;
	this.adj_matrix=new int[nodelist.size()][nodelist.size()];
}
//add for unweighted undirected graph
public void addUndirected_Edge(int i,int j) {
	adj_matrix[i][j]=1;//       i    j
	adj_matrix[j][i]=1;// i     0    1    //(i----j)A------B
}                                   // j     1    0
//add for unweighted -Directed graph
public void addDirected_Edge(int i,int j) {
adj_matrix[i][j]=1;
/*   i      j
 i    0     1       //i-->j(A--->B)
 j    0     0 
 
 */
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
      for (int j :adj_matrix[i]) {
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
  for (int i=0; i<adj_matrix.length; i++) {
    if(adj_matrix[nodeIndex][i]==1) {//condition to get neighbors
      neighbors.add(nodelist.get(i));
    }
  }
  return neighbors;

}

// BSF internall
void bfsVisit(GraphNode node) {
  LinkedList<GraphNode> queue = new LinkedList<GraphNode>();//declare queue ds to store neighbors to visited node
  queue.add(node);//(A,0)
  while(!queue.isEmpty()) {
    GraphNode currentNode = queue.remove(0);//deuque the added node from queue
    currentNode.isVisited = true;//mark dequeued node is visited 
    System.out.print(currentNode.name + " --> ");//print that node
    ArrayList<GraphNode> neighbors = getNeighbors(currentNode);//explore visited node store it in array
    //call second helper method to explore all node
    for (GraphNode neighbor: neighbors) {//loop over exploring node
      if (!neighbor.isVisited) {
        queue.add(neighbor);//after exploring add all node in queue 
        neighbor.isVisited = true;//mark nearest node visited
      }
    }
  }
}
//traversal method-use queue data structure to store data
/*
Start traversing from root node -Explore all node nearest to root node enqueue it in  queue
mark root node is visited node and move the root pointer to nearest node 
again explore all node to that nearest node the same process follows until all node visited
*/
public void breadth_first_search() {
  for (GraphNode node : nodelist) {//(A,0)(B,1)(C,2),(D,3),(E,4)
    if(!node.isVisited) {//true
      bfsVisit(node);//call fisrt helper
    }
  }
}

public void dfsVisit(GraphNode node) {
	Stack<GraphNode> stack=new Stack<GraphNode>();
	stack.push(node);
	while(!stack.isEmpty()) {
		GraphNode current=stack.pop();
		current.isVisited=true;
		System.out.print(current.name+" --> ");
		ArrayList<GraphNode> neighbors=getNeighbors(current);
		for(GraphNode neighbor:neighbors) {
			 if (!neighbor.isVisited) {
			        stack.push(neighbor);
			        neighbor.isVisited = true;
			      }
		}
	}
}
//DFS traversal-use stack data stucture to store neighbors node
public void depth_first_search() {
	for(GraphNode node:nodelist) {
		if(node.isVisited!=false) {
			dfsVisit(node);//call dfs helper method
		}
	}
}
// TOPOLOGICAL SORT
//if there are some sort of action which depend on other action then dependent action will not 
//executed before until its parent action executed
//mainly use with directed graph because of known dependency
//appliaction-scheduling a job where one job depend on other
/*
 if any vertex depends on current vertex
 	move to that vertex
 			THEN back to current vertex
 else
 	push current vertex to stack
 */
public void topological_visit(GraphNode node,Stack<GraphNode> stack) {
	//Stack<GraphNode> stack=new Stack<GraphNode>();
	ArrayList<GraphNode> neighbors=getNeighbors(node);
	for(GraphNode neighbor:neighbors) {
		if(!neighbor.isVisited) {
			topological_visit(neighbor,stack);
		}
	}
	node.isVisited=true;
	stack.push(node);
	
}
public void topological_sort() {
	Stack<GraphNode> stack =new Stack<>();
	for(GraphNode node:nodelist) {
		if(!node.isVisited) {
			topological_visit(node,stack);
		}
	}
	while(!stack.isEmpty()) {
		System.out.println(stack.pop().name+" --> ");
	}
}

public static void main(String[] args) {
	ArrayList<GraphNode> nodelist=new ArrayList<>();
	nodelist.add(new GraphNode("A",0));
	nodelist.add(new GraphNode("B",1));
	nodelist.add(new GraphNode("C",2));
	nodelist.add(new GraphNode("D",3));
	nodelist.add(new GraphNode("E",4));
	
	Adjacency_Main obj=new Adjacency_Main(nodelist);
	obj.addUndirected_Edge(0, 1);
	obj.addUndirected_Edge(0, 2);
	obj.addUndirected_Edge(0, 3);
	obj.addUndirected_Edge(1, 4);
	obj.addUndirected_Edge(2, 3);
	obj.addUndirected_Edge(3, 4);
	System.out.println("Unweighted -UnDirected Graph : \n"+obj.toString());
	System.out.println("--[ BFS Traversal UnDirected Graph ]-- ");
	obj.breadth_first_search();
	System.out.println("\n--[ DFS Traversal UnDirected Graph ]-- ");
	obj.depth_first_search();
	Adjacency_Main obj1=new Adjacency_Main(nodelist);
	obj1.addDirected_Edge(0, 1);
	obj1.addDirected_Edge(0, 2);
	obj1.addDirected_Edge(0, 3);
	obj1.addDirected_Edge(1, 4);
	obj1.addDirected_Edge(2, 3);
	obj1.addDirected_Edge(3, 4);
	System.out.println("\nUnweighted -Directed Graph : \n"+obj1.toString());

    System.out.println("Topological Sort : ");
	obj1.topological_sort();
}
}
