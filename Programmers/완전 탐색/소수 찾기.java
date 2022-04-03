// 13분 54초

import java.util.*;

class Solution {
    
	static Set<Integer> s = new TreeSet<Integer>();
    static String[] nums;
    static boolean[] chosen;
    static int length;
    
    static boolean isPrime(int num) {
        if(num <= 1) return false;
        for(int x = 2; x * x <= num; x++)
            if(num % x == 0) return false;
        return true;
    }
    
    static void go(int cnt, String num) {
        if(num.length() > cnt) return;
        if(!num.equals("") && isPrime(Integer.valueOf(num))) s.add(Integer.valueOf(num));
        
        for(int i = 0; i < length; i++) {
            if(chosen[i]) continue;
            chosen[i] = true;
            go(cnt + 1, num + nums[i]);
            chosen[i] = false;
        }
    }	
    public int solution(String numbers) {
        nums = numbers.split("");
        chosen = new boolean[nums.length];
        length = nums.length;
        
        go(0, "");
        
        return s.size();
    }
}