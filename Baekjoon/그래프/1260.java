// 17분 35초

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int V;
	static List<Integer>[] adj;
	static boolean[] visited;
	
	static void dfs(int u) {
		if(visited[u]) return;
		
		visited[u] = true;
		System.out.print(u + 1 + " ");
		
		for(int i = 0; i < adj[u].size(); i++) 
			dfs(adj[u].get(i));
	}
	
	static void bfs(int u) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(u);
		visited[u] = true;
		
		while(!q.isEmpty()) {
			u = q.poll();
			
			System.out.print(u + 1 + " ");
			
			for(int i = 0; i < adj[u].size(); i++) {
				int v = adj[u].get(i);
				
				if(visited[v]) continue;
				visited[v] = true;
				q.add(v);
			}
 		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int u, v;
		
		N = sc.nextInt();
		M = sc.nextInt();
		V =  sc.nextInt();
		
		adj = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++)
			adj[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			u = sc.nextInt(); 
			v = sc.nextInt();
			
			u--; v--;
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		for(int i = 0; i < N; i++)
			adj[i].sort(Comparator.naturalOrder());	
		
		V--;
		
		dfs(V);
		System.out.println();
		
		Arrays.fill(visited, false);
		bfs(V);
 		
		sc.close();
	}
}