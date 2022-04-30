// 다시 풀기!!

class Solution {
    private static final int INF = 100000000;
    
    public int solution(int n, int[][] results) {
        int[][] d = new int[n + 1][n + 1];
        int i, j, k;
        int len = d.length;
        int ans = 0;
        
        for(i = 1; i < len; i++) 
            for(j = 1; j < len; j++) 
                d[i][j] = INF;        
        
        for(i = 0; i < results.length; i++) {
            int u = results[i][0];
            int v = results[i][1];
            
            d[u][v] = 1;
        }
        
        for(k = 1; k < len; k++) {
            for(i = 1; i < len; i++) {
                for(j = 1; j < len; j++) {
                    if(d[i][j] > d[i][k] + d[k][j])
                        d[i][j] = d[i][k] + d[k][j];
                }
            }
        }
            
        
        for(i = 1; i < len; i++) {
            int cnt = 0;
            for(j = 1; j < len; j++) {

                if(d[i][j] < INF || d[j][i] < INF) 
                    cnt++;
            }
            if(cnt == n - 1) ans++;
        }
        
        return ans;
    }
}