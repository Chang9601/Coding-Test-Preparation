// 21분 32초
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] ans = new int[(int)(right - left + 1)];
        int idx = 0;
        
        for(long i = left; i <= right; i++) {
            int r = (int)(i / n);
            int c = (int)(i % n);
            
            r++;
            c++;
            
            ans[idx++] = Math.max(r, c);
            
        }    
        
        return ans;
    }
}