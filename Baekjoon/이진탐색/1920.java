// 4분 49초
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, num;
	static int[] A;
	
	static boolean go(int x) {
		int l = 0, r = N - 1;
		int m;
		
		while(l <= r) {
			m = (r - l) / 2 + l;
			
			if(A[m] > x) r = m - 1;
			else if(A[m] < x) l = m + 1;
			else return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		A = new int[N];
		
		for(int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		
		Arrays.sort(A);
		
		M = sc.nextInt();
		while(M-- > 0) {
			num = sc.nextInt();
			
			if(go(num)) System.out.println(1);
			else System.out.println(0);
		}
		
		sc.close();
	}
}