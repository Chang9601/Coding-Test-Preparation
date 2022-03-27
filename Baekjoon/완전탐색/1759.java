// 32분 47초
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L;
	static int C;
	static String[] array;
	static boolean[] chosen;
	
	static boolean isVowel(String c) {
		switch(c) {
		case "a":
		case "e":
		case "i":
		case "o":
		case "u":
			return true;
		}
		
		return false;
	}
	
	static void go(int idx, int cnt, int v, int c, String code) {
		if(cnt == L) {
			if(v >= 1 && c >= 2) {
				System.out.println(code);
			}
			return;
		}
		
		for(int i = idx; i < C; i++) {
			if(chosen[i]) continue;

			chosen[i] = true;
			if(isVowel(array[i]))
				go(i, cnt + 1, v + 1, c, code + array[i]);
			else
				go(i, cnt + 1, v, c + 1, code + array[i]);
			chosen[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num;
		String str;
		
		num = sc.nextLine().split(" ");
		str = sc.nextLine();
		
		L = Integer.valueOf(num[0]);
		C = Integer.valueOf(num[1]);
		
		array = str.split(" ");
		chosen = new boolean[C];
		
		Arrays.sort(array);
		go(0, 0, 0, 0, "");
		
		sc.close();
	}
}