package michael.slf4j.learning.leetcode;

public class C45 {

	public static void main(String[] args) {
		C45 c = new C45();
		int[] nums = new int[] {2,3,1,1,4};
		System.out.println(c.jump(nums));
	}

	public int jump(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j <= nums[i] + i && j < len; j++) {
				if(dp[j] != 0) {
					dp[j] = Math.min(dp[j], dp[i] + 1);
				} else {
					dp[j] = dp[i] + 1;
				}
			}
		}
		return dp[len - 1];
	}

}
