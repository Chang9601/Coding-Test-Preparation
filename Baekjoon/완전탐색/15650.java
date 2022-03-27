import java.util.Scanner; // 2분 10초

public class Main {
	static int N;
	static int M;
	static int[] array;
	static boolean[] chosen;
	static StringBuilder ans = new StringBuilder();

	static private void go(int idx, int cnt) {
		if (M == cnt) {
			for (int i = 0; i < cnt; i++)
				ans.append(array[i] + " ");
			ans.append("\n");
			return;
		}

		for (int i = idx; i < N; i++) {
			if (chosen[i] == true)
				continue;
			chosen[i] = true;
			array[cnt] = i + 1;
			go(i, cnt + 1);
			chosen[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		chosen = new boolean[N];
		array = new int[N];
		
		go(0, 0);
		System.out.println(ans);
		
		sc.close();
	}

}