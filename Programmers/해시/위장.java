// 17분

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        int ans = 1;
    
        Map<String, Integer> m = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            if(m.containsKey(clothes[i][1]))
                m.put(clothes[i][1], m.get(clothes[i][1]) + 1);
            else
                m.put(clothes[i][1], 1);
        }
        
        for(Entry<String, Integer> entry : m.entrySet()) {
            ans *= entry.getValue() + 1;
        }
  
        return ans - 1;
    }
}