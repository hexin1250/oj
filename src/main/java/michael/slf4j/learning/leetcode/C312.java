package michael.slf4j.learning.leetcode;

public class C312 {

	public static void main(String[] args) {
	}

	public int maxCoins(int[] nums) {
		int len = nums.length;
		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			int before = 1;
			if(i != 0) {
				before = nums[i - 1];
			}
			int after = 1;
			if(i != len - 1) {
				after = nums[i + 1];
			}
			dp[0][i] = nums[i] * before * after;
		}
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len; j++) {
			}
		}
		return 1;
	}

}
