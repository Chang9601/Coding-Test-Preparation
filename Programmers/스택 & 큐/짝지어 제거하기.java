// 다시 풀기!!

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stk = new Stack<>();
        
        for(Character c : s.toCharArray()) {
            if(!stk.isEmpty() && stk.peek() == c) 
                stk.pop();
            else
                stk.push(c);
            
        }
        
        return stk.isEmpty() ? 1 : 0;
    }
}