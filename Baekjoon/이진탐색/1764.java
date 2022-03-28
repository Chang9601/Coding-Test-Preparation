// 8분 24초
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, M;
	static String[] names;
	
	static boolean go(String name) {
		int l = 0, r = N - 1;
		int m;
		
		while(l <= r) {
			m = (r - l) / 2 + l;
			
			if(name.compareTo(names[m]) < 0) r = m - 1;
			else if(name.compareTo(names[m]) > 0) l = m + 1;
			else return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		List<String> ans = new ArrayList<String>();
		
		String[] str = sc.nextLine().split(" ");
		N = Integer.valueOf(str[0]);
		M = Integer.valueOf(str[1]);
		names = new String[N];
		
		for(int i = 0; i < N; i++)
			names[i] = sc.nextLine();
		
		Arrays.sort(names);
		
		while(M-- > 0) {
			name = sc.nextLine();
			if(go(name)) ans.add(name);
		}
		
		ans.sort(Comparator.naturalOrder());
		System.out.println(ans.size());
		for(String s : ans)
			System.out.println(s);
		
		sc.close();
	}
}