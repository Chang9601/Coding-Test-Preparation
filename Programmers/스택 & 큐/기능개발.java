// 다시 풀기!!
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = speeds.length;
        int[] dists = new int[len];
        int[] ans;
        List<Integer> l = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        
        for(int i = len - 1; i >= 0; i--) { // LIFO, 역순으로
            int diff = 100 - progresses[i];
            int val = (diff % speeds[i] == 0) ? diff / speeds[i] : (diff / speeds[i]) + 1;
            s.add(val);
        }
        
        while(!s.isEmpty()) {
            int cnt = 1;
            int top = s.pop();
            
            while(!s.isEmpty() && s.peek() <= top) {
                cnt++;
                s.pop();
            }
            
            l.add(cnt);
        }
        
        ans = new int[l.size()];
        for(int i = 0; i < l.size(); i++)
            ans[i] = l.get(i);
        return ans;
    }
}