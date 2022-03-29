// 5분 35초

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
	
public class Main {
	static int N, M;
	static List<Integer>[] adj;
	static boolean[] visited;
	
	static void go(int u) {
		if(visited[u]) return;
		
		visited[u] = true;
		
		for(int i = 0; i < adj[u].size(); i++) {
			int v = adj[u].get(i);
			go(v);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ans = 0;
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N];
		adj = new ArrayList[N];
		
		for(int i = 0; i < N; i++)
			adj[i] = new ArrayList<Integer>();
		
		while(M-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			u--;
			v--;
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				go(i);
				ans++;
			}
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}