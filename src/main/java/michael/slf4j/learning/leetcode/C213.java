package michael.slf4j.learning.leetcode;

public class C213 {

	public static void main(String[] args) {
		C213 c = new C213();
		int[] nums = new int[] {200,3,140,20,10};
		System.out.println(c.rob(nums));
	}

	public int rob(int[] nums) {
		int len = nums.length;
		if(len == 1) {
			return nums[0];
		} else if(len == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int[] dp1 = new int[len - 1];
		dp1[0] = nums[0];
		dp1[1] = Math.max(nums[0], nums[1]);
		int[] dp2 = new int[len - 1];
		dp2[0] = nums[1];
		dp2[1] = Math.max(nums[1], nums[2]);
		for (int i = 2; i < len - 1; i++) {
			dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
			dp2[i] = Math.max(dp2[i - 2] + nums[i + 1], dp2[i - 1]);
		}
		return Math.max(dp1[len - 2], dp2[len - 2]);
	}

}
