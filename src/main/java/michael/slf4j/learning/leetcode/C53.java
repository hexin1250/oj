package michael.slf4j.learning.leetcode;

public class C53 {

	public static void main(String[] args) {
	}

	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}

}
