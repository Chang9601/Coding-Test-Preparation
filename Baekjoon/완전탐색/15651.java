import java.util.Scanner; // 1분 50초

public class Main {
	static int N;
	static int M;
	static int[] array;
	static StringBuilder ans = new StringBuilder();

	static private void go(int cnt) {
		if (M == cnt) {
			for (int i = 0; i < cnt; i++)
				ans.append(array[i] + " ");
			ans.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			array[cnt] = i + 1;
			go(cnt + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		array = new int[N];
		
		go(0);
		System.out.println(ans);
		
		sc.close();
	}

}