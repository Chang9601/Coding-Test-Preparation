// 다시 풀기!!
import java.lang.*;

class Solution {
    public String solution(int n) {
        String[] digits = {"4", "1", "2"};
        String ans = "";
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            int idx = n % 3;
            n /= 3;
            
            if(idx == 0) n--;
            
            sb.insert(0, digits[idx]);
        }

        return sb.toString();
    }
}