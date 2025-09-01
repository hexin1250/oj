package michael.slf4j.learning.leetcode;

public class C413 {

	public static void main(String[] args) {
	}

	public int numberOfArithmeticSlices(int[] nums) {
		int len = nums.length;
		if(len <= 2) {
			return 0;
		}
		int offset = nums[1] - nums[0];
		int sum = 0;
		int count = 0;
		for (int i = 2; i < len; i++) {
			int currentOffset = nums[i] - nums[i - 1];
			if(currentOffset == offset) {
				count += 1;
				sum += count;
			} else {
				count = 0;
				offset = currentOffset;
			}
		}
		return sum;
	}

}
