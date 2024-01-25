package level1;

import java.util.ArrayList;

import level1.BFS.Edge;

public class DFS {
	
	static class Edge{
		int src;
		int dest;
		public Edge(int s,int d) {
			this.src = s;
			this.dest = d;
		}
		
	}
	public static void CreateGraph(ArrayList<Edge> graph[]) {
		int n = graph.length;
		for(int i=0;i<n;i++){
			graph[i]=new ArrayList<Edge>();
		}
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,2));
		
		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,3));
		
		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,4));
		
		graph[3].add(new Edge(3,1));
		graph[3].add(new Edge(3,4));
		graph[3].add(new Edge(3,5));
		
		graph[4].add(new Edge(4,2));
		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));
		
		graph[5].add(new Edge(5,3));
		graph[5].add(new Edge(5,4));
		graph[5].add(new Edge(5,6));
		
		graph[6].add(new Edge(6,5));
	}
	
	public static void dfs(ArrayList<Edge> graph[],int curr, boolean vis[]) { //o(v+e)
		System.out.print(curr +" ");
		vis[curr]=true;
		// for neighbor
		for(int i=0;i<graph[curr].size();i++){
			Edge e = graph[curr].get(i);
			if(vis[e.dest]==false) {
				dfs(graph,e.dest,vis); 
			}
			
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 7;
		ArrayList<Edge> graph[] = new ArrayList[V];
		CreateGraph(graph);
		boolean vis[] = new boolean[V];
		for(int i=0;i<V;i++) {
			if(vis[i]==false) { //  agar mera neighbour avi tk visit nhi hua hai tabhi to dfs ke liye call krenge
				dfs(graph,i,vis);
			}
		}
		System.out.println();

	}

}
