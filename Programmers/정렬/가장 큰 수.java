// 다시 풀기!!

import java.util.*;

class Comp implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
        String a = o1 + o2;
        String b = o2 + o1;
        
		return b.compareTo(a);
	}
}

class Solution {
    public String solution(int[] numbers) {
        int len = numbers.length;
        String[] nums = new String[len];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < len; i++)
            nums[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(nums, new Comp());    
        for(String str : nums)
            sb.append(str);
        
        String ans = sb.toString().charAt(0) == '0' ? "0" : sb.toString();
        return ans;
    }
}