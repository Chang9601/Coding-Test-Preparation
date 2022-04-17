// 12분 55초
class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int i = 0;
        
        while(i < len) {
            char ch = s.charAt(i++);
            
            if(((i == 1) || (s.charAt(i - 2) == ' ')) && Character.isAlphabetic(ch))
                sb.append(Character.toUpperCase(ch));
            else
                sb.append(ch);
        }
        
        return sb.toString();
    }
}