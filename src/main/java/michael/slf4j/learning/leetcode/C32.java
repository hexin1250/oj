package michael.slf4j.learning.leetcode;

public class C32 {

	public static void main(String[] args) {
		C32 c = new C32();
		String s = ")(((((()())()()))()(()))(";
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		
		System.out.println(c.longestValidParentheses(s));
	}
	
	public int longestValidParentheses(String s) {
		char[] arr = s.toCharArray();
		int len = arr.length;
		int[] dp = new int[len];
		int max = 0;
		for (int i = 1; i < len; i++) {
			if(i == 23) {
				System.out.println("break here");
			}
			char c = arr[i];
			if(c == ')') {
				if(arr[i - 1] == '(') {
					if(i >= 2) {
						dp[i] = dp[i - 2] + 2;
					} else {
						dp[i] = 2;
					}
				} else {
					if(dp[i - 1] > 0) {
						int prevDp = dp[i - 1];
						int left = i - (prevDp + 1);
						if(left >= 0 && arr[left] == '(') {
							dp[i] = prevDp + 2;
						}
					}
				}
			}
			int lastIndex = i - dp[i];
			if(lastIndex > 0) {
				dp[i] += dp[lastIndex];
			}
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}
	
}
