// 14분 16초
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int R, C;
	static String[] grid;
	static boolean[][] visited;
	static int V, O;
	
	static boolean isVorO(Character c) {
		return c == 'v' || c == 'o' ? true: false;
	}
	
	static void go(int x, int y) {
		if(x < 0 || x >= R || y < 0 || y >= C) return;
		if(visited[x][y]) return;
		if(grid[x].charAt(y) == '#') return;
		
		V += grid[x].charAt(y) == 'v' ? 1 : 0;
		O += grid[x].charAt(y) == 'o' ? 1 : 0;
		
		visited[x][y] = true;
		
		go(x - 1, y);
		go(x + 1, y);
		go(x, y - 1);
		go(x, y + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num;
		int numO, numV;
		
		num = sc.nextLine().split(" ");
		numO = numV = 0;
		
		R = Integer.valueOf(num[0]);
		C = Integer.valueOf(num[1]);
		visited = new boolean[R][C];
		
		grid = new String[R];
		for(int i = 0; i < R; i++)
			grid[i] = sc.nextLine();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(isVorO(grid[i].charAt(j)) && !visited[i][j]) {
					V = O = 0;
					go(i, j);
					
					if(O > V) numO += O;
					else numV += V;
				}
			}
		}
		
		System.out.println(numO + " " + numV);
		
		sc.close();
	}
}