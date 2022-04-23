// 18분 34초
class Solution {
	private static String toBinary(int num) {
		StringBuilder sb = new StringBuilder();

		do {
			sb.append(num % 2);
			num /= 2;
		} while (num > 0);

		return sb.reverse().toString();
	}

	public static int[] go(String s) {
		int cnt = 0;
		int zeros = 0;

		while (!s.equals("1")) {
			StringBuilder sb = new StringBuilder();			
			cnt++;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1')
					sb.append(s.charAt(i));
				else
					zeros++;
			}
			System.out.println(s);;
			s = toBinary(sb.length());
		}

		int[] ans = new int[2];
		ans[0] = cnt;
		ans[1] = zeros;

		return ans;
	}

    public int[] solution(String s) {
        return go(s);
    }
}