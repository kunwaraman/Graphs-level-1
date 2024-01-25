package Question;

import java.util.ArrayList;



public class AllPathFromSourceToTarget {
	static class Edge{
		int src;
		int dest;
		public Edge(int s, int d) {
			
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
	
	public static void printAllPath(ArrayList<Edge> graph[],boolean vis[],int curr,String path,int target){ //o(v^v)
		if(curr==target) {
			System.out.println(path);
			return;
		}
		for(int i=0;i<graph[curr].size();i++){
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]) {
				vis[curr]=true;
				printAllPath(graph,vis,e.dest,path+e.dest,target);
				vis[curr]=false;
			}
		}
		
	}

	public static void main(String[] args) {	
		int V = 7;
		ArrayList<Edge> graph[] = new ArrayList[V];
		CreateGraph(graph);
		
		int src =0;
		int target =5;
		printAllPath(graph,new boolean[V],src,"0",target);

	}

}
