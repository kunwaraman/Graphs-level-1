package level1;

import java.util.ArrayList;

public class CycleDetection {
	static class Edge{
		int src;
		int dest;
		public Edge(int s,int d) {
			this.src=s;
			this.dest =d;
		}
		
	}
	
	public static void CreateGraph(ArrayList<Edge> graph[]) {
		int n = graph.length;
		for(int i=0;i<n;i++){
			graph[i]=new ArrayList<Edge>();
		}
		graph[0].add(new Edge(0,2));
	    
		graph[1].add(new Edge(1,0));
		
		graph[2].add(new Edge(2,3));
		
		graph[3].add(new Edge(3,0));
	}
	
	public static boolean isCycleDirected(ArrayList<Edge> graph[],boolean vis[],int curr,boolean rec[]){
		vis[curr]=true;
		rec[curr]=true;
		
		for(int i=0;i<graph[curr].size();i++) {
			Edge e = graph[curr].get(i);
			if(rec[e.dest]==true){
				return true;
			}else if(!vis[e.dest]) {
				if(isCycleDirected(graph,vis,e.dest,rec)) {  // agar ush neighbour ke wha pe cycle exist krti hogi to bhi to mere graph ke 
					// andar cycle exist krti hai
					return true;
				}
			}
		}
		rec[curr]=false;
		return false;		
	}
	
	public static void main(String[] args) {
		int V = 4;
		ArrayList<Edge> graph[] = new ArrayList[V];
		CreateGraph(graph);
//		System.out.println(isCycleDirected(graph,new boolean[V],0,new boolean[V]));
		// to travel all the points of graph
		boolean vis[] = new boolean[V];
		boolean rec[] = new boolean[V];
		for(int i=0;i<V;i++) {
			if(!vis[i]) {
				boolean isCycle = isCycleDirected(graph,vis,0,rec);
				if(isCycle) {
					System.out.println(isCycle);
					break;
				}
			}
		}

	}

}
