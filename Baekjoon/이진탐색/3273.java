// 11분 6초

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
	
public class Main {
	static int n, x;
	static int[] a;
	static Set<Integer> set = new HashSet<Integer>();
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ans = 0;
		n = sc.nextInt();
		a = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			set.add(a[i]);
		}
		
		Arrays.sort(a);
		x = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int other = x - a[i];
			if(set.contains(other)) 
				ans++;
		}
		
		System.out.println(ans / 2);
		
		sc.close();
	}
}