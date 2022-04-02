// 2분 20초

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int location = commands[i][2] - 1;
            
            int[] arr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(arr);
            ans[i] = arr[location];
        }
        
        return ans;
    }
}