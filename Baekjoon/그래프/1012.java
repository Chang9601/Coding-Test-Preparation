// 9분 1초

import java.util.Scanner;

public class Main {
	static int T;
	static int M;
	static int N;
	static int K;
	static int[][] grid;
	static boolean[][] visited;
	
	static void go(int x, int y) {
		if(x >= N || x < 0 || y >= M || y < 0) return;
		if(visited[x][y] || grid[x][y] == 0) return;
		
		visited[x][y] = true;
		
		go(x - 1, y);
		go(x + 1, y);
		go(x, y - 1);
		go(x, y + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 		int x, y;
 		
		T = sc.nextInt();
		
		while(T-- > 0) {
			int ans = 0;
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			grid = new int[N][M];
			visited = new boolean[N][M];

			for(int i = 0; i < K; i++) {
				y = sc.nextInt();
				x = sc.nextInt();
				
				grid[x][y] = 1;
				
			}
	
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < M; j++) {
					if(grid[i][j] != 0 && !visited[i][j]) {
						go(i, j);
						ans++;
					}
				}
			
			System.out.println(ans);
			
		}
		sc.close();
	}
}