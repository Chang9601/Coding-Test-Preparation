// 30분 22초
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        Map<String, Integer> m = new TreeMap<>();
        Set<String> dup = new TreeSet<>();
        int[] indegrees = new int[len];
        List<Integer>[] adj = new ArrayList[len];
        Set<Integer> validReportedId = new TreeSet<>();        
        int[] ans = new int[len];
        
        for(int i = 0; i < len; i++)
            adj[i] = new ArrayList<Integer>();
        
        for(int i = 0; i < len; i++) {
            m.put(id_list[i], i);
        }
        
        for(int i = 0; i < report.length; i++) {
            String[] names = report[i].split(" ");
            int reportId = m.get(names[0]);
            int reportedId = m.get(names[1]);
            
            if(dup.contains(names[0]+ " " + names[1])) continue;
            dup.add(names[0]+ " " + names[1]);
            
            indegrees[reportedId]++;
            adj[reportId].add(reportedId);
        }
        
        for(int i = 0; i < len; i++) {
            if(indegrees[i] >= k) {
                validReportedId.add(i);
            }
        }
        
        for(int i = 0; i < adj.length; i++) {
            int num = 0;
            for(int j = 0; j < adj[i].size(); j++) {
                if(validReportedId.contains(adj[i].get(j)))
                    num++;
            }
            ans[i] = num;    
        }
        
        return ans;
    }
}