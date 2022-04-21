// 14분 19초

class Solution {
    static int ans;
    static int[] idx;
    static boolean[] chosen;
    
    private static void go(int cnt, int k, int[][] dungeons) {
        if(cnt == dungeons.length) {
            int ret = 0;
            int t = k;
            for(int i = 0; i < cnt; i++) {
                if(t >= dungeons[idx[i]][0]) {
                    t -= dungeons[idx[i]][1];
                    ret++;
                }
            }
            ans = Math.max(ans, ret);
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(chosen[i]) continue;
            
            chosen[i] = true;
            idx[cnt] = i;
            go(cnt + 1, k, dungeons);
            chosen[i] = false;
        }
        
    }
    
    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;   
        idx = new int[len];
        chosen = new boolean[len];
     
        ans = -1;
        go(0, k, dungeons);
        
        return ans;
    }
}