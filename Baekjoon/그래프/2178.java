// 17분 22초

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
	
class Point {
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
};

public class Main {
	
	static int N, M;
	static int[][] grid;	
	static int[][] dist;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void go(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		
		dist[x][y] = 0;
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(dist[nx][ny] != -1 || grid[nx][ny] == 0) continue;
				
				q.add(new Point(nx, ny));
				dist[nx][ny] = dist[p.x][p.y] + 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		
		String[] nums = sc.nextLine().split(" ");
		N = Integer.valueOf(nums[0]);
		M = Integer.valueOf(nums[1]);
		
		grid = new int[N][M];
		dist = new int[N][M];
		
		for(int i = 0; i < N; i++)
			Arrays.fill(dist[i], -1);

		for(int i = 0; i < N; i++) {
			line = sc.nextLine();
			for(int j = 0; j < M; j++)
				grid[i][j] = Integer.valueOf(line.charAt(j) + "");
		}
		
		go(0, 0);
		System.out.println(dist[N - 1][M - 1] + 1);
		
		sc.close();
	}
}