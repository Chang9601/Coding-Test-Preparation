import java.util.Scanner; // 13분 14초

public class Main {
	static int N;
	static int[] array;
	static int min, max;
	static int[] ops;

	static void go(int sum, int cnt, int add, int sub, int mul, int div) {
		if(cnt == N) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			
			return;
		}
		
		if(add > 0) go(sum + array[cnt], cnt + 1, add - 1, sub, mul, div); 
		if(sub > 0) go(sum - array[cnt], cnt + 1, add, sub - 1, mul, div); 
		if(mul > 0) go(sum * array[cnt], cnt + 1, add, sub, mul - 1, div); 
		if(div > 0) go(sum / array[cnt], cnt + 1, add, sub, mul, div - 1); 
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		array = new int[N];
		ops = new int[4];
		
		for(int i = 0; i < N; i++)
			array[i] = sc.nextInt();
		// +, -, *, /
		for(int i = 0; i < 4; i++)
			ops[i] = sc.nextInt();
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		go(array[0], 1, ops[0], ops[1], ops[2], ops[3]);
		
		System.out.println(max);
		System.out.println(min);
		
		sc.close();
	}
}