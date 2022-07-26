package Adjacency_matrix;

public class Floyd_WarShell {
 public static final int MAX_VALUE=999;
 public static final int INF=999;
	private void algo_FloydWarshell(int[][] graph) {
		int [][] dist=graph;
		for(int i=0;i<graph.length;i++) {
			
			for(int j=0;j<graph.length;j++) {
				
				for(int k=0;k<graph.length;k++) {
					
					if(dist[i][j]+dist[i][k]<dist[j][k]) {
						dist[j][k]=dist[i][j]+dist[i][k];
					}
				}
			}
		}
		printPath(dist);
		
	}
	private void printPath(int[][] dist) {
		for(int source=0;source<dist.length;source++) {
			for(int dest=0;dest<dist.length;dest++) {
				if(dist[source][dest]==INF) {
					System.out.println("INF ");
				}
				else {
					System.out.print(dist[source][dest]+" ");
				}
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
//		int graph[][]= {{0,8,MAX_VALUE,1},{MAX_VALUE,0,1,MAX_VALUE},
//				{4,MAX_VALUE,0,MAX_VALUE},{MAX_VALUE,2,9,0}};
		int graph[][]= {{ 0, 3, INF, 5 }, { 2, 0, INF, 4 }, { INF, 1, 0, INF }, { INF, INF, 2, 0 } };
	 Floyd_WarShell obj=new Floyd_WarShell();
	 obj.algo_FloydWarshell(graph);
	 
	}


}
