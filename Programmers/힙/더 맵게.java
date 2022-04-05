// 23분 13초
import java.util.*;

class Solution {
  
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int ans = 0;
        
        for(int s : scoville)
            pq.add(s);
        
        while(true) {
            if(pq.peek() >= K) break;
            if(pq.peek() < K && pq.size() == 1) return -1;
            
            int min = pq.poll();
            int nextMin = pq.poll();
            pq.add(min + (nextMin * 2));
        
            ans++;
            
        }
        
        return ans;
    }
}