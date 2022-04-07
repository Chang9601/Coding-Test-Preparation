// 1분 21초

class Solution {
    public int solution(int[] numbers) {
        int ans = 9 * 10 / 2;
        for(int num : numbers)
            ans -= num;
        
        return ans;
    }
}