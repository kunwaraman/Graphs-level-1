package level1;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
	static class Edge{
		int src;
		int dest;
		public Edge(int s ,int d) {
			this.src = s;
			this.dest = d;
			
		}
		
	}
	public static void CreateGraph(ArrayList<Edge> graph[]) {
		int n = graph.length;
		for(int i=0;i<n;i++) {
			graph[i]=new ArrayList<Edge>();
		}
		graph[2].add(new Edge(2,3));
		
		graph[3].add(new Edge(3,1));
		
		graph[4].add(new Edge(4,0));
		graph[4].add(new Edge(4,1));
		
		graph[5].add(new Edge(5,0));
		graph[5].add(new Edge(5,2));
	}
	
	public static void topological(ArrayList<Edge> graph[],int curr ,boolean vis[], Stack<Integer>stack) {
		vis[curr]=true;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]) {
				topological(graph,e.dest,vis,stack);
			}
		}
		stack.push(curr);	
		
	}
	
	public static void topologicalSort(ArrayList<Edge> graph[],int V){
		boolean vis[] = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<V;i++) {
			if(!vis[i]) {
				topological(graph,i,vis,stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 6;
		ArrayList<Edge> graph[] = new ArrayList[V];
		CreateGraph(graph);
		topologicalSort(graph,V);

	}

}
