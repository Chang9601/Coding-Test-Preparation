import java.util.Scanner; // 17분 30초

public class Main {
	static int N;
	static int S;
	static int[] array;
	static int ans;

	static private void go(int sum, int cnt) {
		if(cnt == N) {
			if (sum == S) {
				ans++;		
			}
			return;
		}

		go(sum + array[cnt], cnt + 1);
		go(sum, cnt + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		array = new int[N];
		for(int i = 0; i < N; i++)
			array[i] = sc.nextInt();
		
		go(0, 0); 
		if(S == 0) ans--; // 0일 경우 공집합 제외
		System.out.println(ans);
		
		sc.close();
	}

}