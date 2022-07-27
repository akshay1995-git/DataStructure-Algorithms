package Kruskal_algo;

import java.util.Scanner;

public class Kruskal_Algorithm {

	int parent[];
	int size;

	Kruskal_Algorithm(int size) {
		this.size = size;
		parent = new int[size];
	}

	int find(int m) {
		if (parent[m] == 0) {
			return m;
		} else {
			return find(parent[m]);
		}
	}

	void union(int i, int j) {
		if (i > j)
			parent[i] = j;
		else
			parent[j] = i;
	}

	void kruskal_algorithm(int[][] graph) {
		int u = 0, v = 0, min, k = 0, i, j, sum = 0;
		while (k < graph.length) {
			min = 99;
			for (i = 0; i < graph.length; i++)
				for (j = 0;j < graph.length; j++)
					if (graph[i][j] < min) {
						min = graph[i][j];
						u = i;
						v = j;
					}
			i = find(u);
			j = find(v);
			if (i != j) {
				union(i, j);
				System.out.println("(" + u + "," + v + ")" + "=" + graph[u][v]);
				sum = sum + graph[u][v];
				k++;
			}
			graph[u][v] = graph[v][u] = 99;
		}
		System.out.println("The cost of minimum spanning tree = " + sum);
	}

	public static void main(String[] args) {
	int graph[][]=new int[10][10];
	int i,j;
	System.out.println("Enter the number of vertices of the graph");
	Scanner sc=new Scanner(System.in);

	int n;
	n=sc.nextInt();
	System.out.println("Enter the wieghted matrix");
	for(i=0;i<n;i++)
	for(j=0;j<n;j++)
	graph[i][j]=sc.nextInt();
	// a={{0,3,99,99,6,5},{3,0,1,99,99,4},{99,1,0,6,99,4},
	// {99,99,6,0,8,5},{6,99,99,8,0,2},{5,4,4,5,2,0}};
	// 0 3 99 99 6 5
	// 3 0 1 99 99 4
	// 99 1 0 6 99 4
	// 99 99 6 0 8 5
	// 99 99 6 0 8 2
	//5 4 4 5 2 0
	Kruskal_Algorithm k=new Kruskal_Algorithm(n);
	k.kruskal_algorithm(graph);
	sc.close();
	}
	}