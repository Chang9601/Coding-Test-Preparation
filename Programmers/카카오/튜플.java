// 55분 44초, 다른 접근 보기

import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        String[] arr = s.split(",(?=\\{)");
        List<Integer>[] list = new ArrayList[arr.length];
        Set<Integer> set = new TreeSet<Integer>();
        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < list.length; i++)
            list[i] = new ArrayList<Integer>();

        for(int i = 0; i < arr.length; i++) {
            for(int j = 1; j < arr[i].length(); j += 2) {
                int num = 0;
                while(Character.isDigit(arr[i].charAt(j))) {
                    num = num * 10 + (arr[i].charAt(j) - '0');
                    j++;
                }
                j--;
                list[i].add(num);
            }
        }

        int cnt = list.length;
        int idx = 1;
        int size = 1;

        while (cnt > 0) {
            for (int i = 0; i < list.length; i++) {
                if (size == list[i].size()) {
                    idx = i;
                    break;
                }
            }

            for (int i = 0; i < list[idx].size(); i++) {
                int num = list[idx].get(i);
                if (set.contains(num))
                    continue;

                ans.add(num);
                set.add(num);
            }

            size++;
            cnt--;
        }


        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);
        return answer;
    }
}