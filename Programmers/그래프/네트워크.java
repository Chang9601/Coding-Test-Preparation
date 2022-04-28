// 14분 34초

class UnionFind {
    int[] r;
    int[] s;
    
    public UnionFind(int n) {
        r = new int[n];
        s = new int[n];
        int i;
        
        for(i = 0; i < n; i++) {
            r[i] = i;
            s[i] = 1;
        }
    }
    
    public int find(int u) {
        if(u == r[u]) return u;
        return r[u] = find(r[u]);
    }
    
    public int merge(int u, int v) {
        u = find(u);
        v = find(v);
        
        if(u == v) return 0;
        
        if(s[u] > s[v]) {
            s[u] += s[v];
            r[v] = u;
        } else {
            s[v] += s[u];
            r[u] = v;
        }
        
        return 1;
    }
}

class Solution {
    public int solution(int n, int[][] computers) {
        UnionFind uf = new UnionFind(n);
        int ans = n;
        int r = computers.length;
        int c = computers[0].length;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(computers[i][j] == 1)
                    ans -= uf.merge(i, j);             
            }
        }
        
        return ans;
    }
}