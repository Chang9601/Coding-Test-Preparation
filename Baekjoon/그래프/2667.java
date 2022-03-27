// 8분 32초
package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] grid;
	static boolean[][] visited;
	static List<Integer> list;
	
	static int go(int x, int y) {
		if(x >= N || x < 0 || y >= N || y < 0) return 0;
		if(visited[x][y] == true || grid[x][y] == 0) return 0;
		
		visited[x][y] = true;

		return 1 + go(x - 1, y) + go(x + 1, y) + go(x, y - 1) + go(x, y + 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 		
		N = Integer.valueOf(sc.nextLine());
		int i, j;
		String line;
		
		list = new ArrayList<>();
		grid = new int[N][N];
		visited = new boolean[N][N];
		
		for(i = 0; i < N; i++) {
			line = sc.nextLine();
			for(j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(line.charAt(j) + "");
			}
		}
		
		for(i = 0; i < N; i++) {
			for(j = 0; j < N; j++) {
				if(grid[i][j] != 0 && visited[i][j] == false) {
					int size = go(i, j);
					list.add(size);
				}
			}
		}
		
		System.out.println(list.size());
		list.sort(Comparator.naturalOrder());
		for(int size : list)
			System.out.println(size);
		
		sc.close();
	}
}