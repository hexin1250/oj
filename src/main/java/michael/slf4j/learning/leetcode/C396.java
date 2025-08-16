package michael.slf4j.learning.leetcode;

public class C396 {

	public static void main(String[] args) {
	}

	public int maxRotateFunction(int[] nums) {
		int len = nums.length;
		int sum = 0;
		int total = 0;
		for (int i = 0; i < len; i++) {
			sum += nums[i];
			total += i * nums[i];
		}
		int max = total;
		for (int i = 0; i < len - 1; i++) {
			total = total - (sum - nums[i]) + (len - 1) * nums[i];
			max = Math.max(max, total);
		}
		return max;
	}

}
