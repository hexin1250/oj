package michael.slf4j.learning.leetcode;

public class C153New {

	public static void main(String[] args) {
		C153New c = new C153New();
		int[] nums = new int[] {2,-5,-2,-4,3};
//		int[] nums = new int[] {0};
		System.out.println(c.maxProduct(nums));
	}

	public int maxProduct(int[] nums) {
		int len = nums.length;
		int max = Integer.MIN_VALUE;
		int negativeCount = 0;
		int headSum = 0;
		int tailSum = 0;
		int tmp = 1;
		for (int i = 0; i < len; i++) {
			if(nums[i] == 0) {
				max = Math.max(0, max);
				negativeCount = 0;
				headSum = 0;
				tailSum = 0;
				tmp = 1;
				continue;
			}
			max = Math.max(nums[i], max);
			if(negativeCount > 0) {
				if(tailSum == 0) {
					tailSum = 1;
				}
				tailSum *= nums[i];
			}
			if(nums[i] < 0) {
				negativeCount++;
			}
			tmp *= nums[i];
			if(tmp > 0) {
				if(headSum == 0) {
					headSum = 1;
				}
				headSum *= tmp;
				tmp = 1;
			}
			if(headSum > 0 && headSum > max) {
				max = headSum;
			}
			if(tailSum > 0 && tailSum > max) {
				max = tailSum;
			}
		}
		return max;
	}

}
