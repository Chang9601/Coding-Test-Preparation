// 27분 59초, 다른 접근 보기
import java.util.*;

class Doc {
    int idx;
    int val;
    
    Doc(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int ans = 0;
        Queue<Doc> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < priorities.length; i++) {
            q.add(new Doc(i, priorities[i]));
            pq.add(priorities[i]);
        }
        
        ans = 1;
        while(true) {
            int maxPriority = pq.peek();
            Doc currDoc = q.peek();
            
            if(maxPriority == currDoc.val) {
                if(currDoc.idx == location)
                    break;
                q.poll();
                pq.poll();
                ans++;
            } else {
                currDoc = q.poll();
                q.add(currDoc);
            }
        }
        
        return ans;
    }
}