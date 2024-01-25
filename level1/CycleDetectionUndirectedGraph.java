package level1;

import java.util.ArrayList;

public class CycleDetectionUndirectedGraph {
	static class Edge{
		int src;
		int dest;
		public Edge(int s ,int d) {
			this.src= s;
			this.dest = d;
		}
			
	}
	public static void CreateGraph(ArrayList<Edge> graph[]) {
		int n = graph.length;
		for(int i=0;i<n;i++) {
			graph[i]=new ArrayList<Edge>();
		}
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,4));
		
		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,2));
		//graph[1].add(new Edge(1,4));
		
		graph[2].add(new Edge(2,1));
		graph[2].add(new Edge(2,3));
		
		graph[3].add(new Edge(3,2));
		
		graph[4].add(new Edge(4,0));
		//graph[4].add(new Edge(4,1));
		graph[4].add(new Edge(4,5));
		
		graph[5].add(new Edge(5,4));
	}
	public static boolean isCycleUndirectedGraph(ArrayList<Edge> graph[],boolean vis[], int curr, int parent) {
		vis[curr] = true;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e = graph[curr].get(i);
			// 1st cond
			if(vis[e.dest] && e.dest!=parent) {
				return true;
			}
			// 2nd cond
			else if(!vis[e.dest]) {
				if(isCycleUndirectedGraph(graph,vis,e.dest,curr)==true) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 6;
		ArrayList<Edge> graph[] = new ArrayList[V];
		CreateGraph(graph);
		System.out.println(isCycleUndirectedGraph(graph, new boolean[V], 0, -1));

	}

}
