// 다시 풀기!!
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> s = new HashSet<>();
        
        for(String num : phone_book)
            s.add(num);
        
        for(String num : phone_book) {
            for(int i = 0; i < num.length(); i++) {
                if(s.contains(num.substring(0, i)))
                    return false;
            }
        }
        
        return true;
    }
}