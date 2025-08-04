package michael.slf4j.learning.leetcode;

public class C3202 {

	public static void main(String[] args) {
		C3202 c = new C3202();
		int[] nums = new int[] {1,2,3,10,2};
		int k = 6;
		System.out.println(c.maximumLength(nums, k));
	}

	public int maximumLength(int[] nums, int k) {
		int max = 0;
		int[][] dp = new int[k][k];
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i] % k;
			for (int j = 0; j < k; j++) {
				dp[j][num] = dp[num][j] + 1;
				if(max < dp[j][num]) {
					max = dp[j][num];
				}
			}
		}
		return max;
	}

}
