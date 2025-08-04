package michael.slf4j.learning.leetcode;

public class C673 {

	public static void main(String[] args) {
		C673 c = new C673();
		int[] nums = new int[] {2,2,2,2,2};
//		int[] nums = new int[] {1,3,5,4,7};
		System.out.println(c.findNumberOfLIS(nums));
	}

	public int findNumberOfLIS(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len + 1];
		for (int i = 1; i <= len; i++) {
			for (int j = i + 1; j <= len; j++) {
				if(nums[i - 1] <= nums[j - 1]) {
					dp[j] = Math.max(dp[i] + 1, dp[j - 1]);
				}
			}
		}
		int max = -1;
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
