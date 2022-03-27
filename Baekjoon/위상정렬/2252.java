// 10분 15초

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] indegrees;
	static List<Integer>[] adj;
	static List<Integer> ans;
	
	static void go() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++)
			if(indegrees[i] == 0)
				q.add(i);
		
		while(!q.isEmpty()) {
			int u = q.poll();
			ans.add(u);
			
			for(int i = 0; i < adj[u].size(); i++) {
				int v = adj[u].get(i);
				
				if(--indegrees[v] == 0)
					q.add(v);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 		
		N = sc.nextInt();
		M = sc.nextInt();
		indegrees = new int[N + 1];
		adj = new ArrayList[N + 1];
		ans = new ArrayList<Integer>();
		int u, v;
		
		for(int i = 1; i <= N; i++)
			adj[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			
			adj[u].add(v);
			indegrees[v]++;
		}
		
		go();
		
		for(int n : ans)
			System.out.print(n + " ");
		
		sc.close();
	}
}