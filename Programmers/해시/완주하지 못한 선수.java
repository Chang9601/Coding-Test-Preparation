// 21분 49초

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String ans = "";
        Map<String, Integer> m = new HashMap<>();
        
        for(String p : participant) {
            if(m.containsKey(p))
                m.put(p, m.get(p) + 1);
            else
                m.put(p, 1);
        }
        
        for(String c : completion)  
            m.put(c, m.get(c) - 1);
          
        for(Entry<String, Integer> entry : m.entrySet()) {
            if(entry.getValue() != 0)
                ans = entry.getKey();
        }
        
        return ans;
    }
}