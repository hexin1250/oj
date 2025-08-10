package michael.slf4j.learning.leetcode;

public class C343New {

	public static void main(String[] args) {
		C343New c = new C343New();
		System.out.println(c.integerBreak(12));
	}

	public int integerBreak(int n) {
		if (n == 2) {
			return 1;
		} else if (n == 3) {
			return 2;
		} else if (n == 4) {
			return 4;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 4;
		for (int i = 5; i <= n; i++) {
			int currentMax = 1;
			for (int j = 2; j < i / 2 + 1; j++) {
				int multiNumber = dp[j] * dp[i - j];
				currentMax = Math.max(currentMax, multiNumber);
			}
			dp[i] = currentMax;
		}
		return dp[n];
	}

}
