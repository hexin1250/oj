package michael.slf4j.learning.leetcode;

public class C312 {

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 1, 5, 8 };
		C312 c = new C312();
		System.out.println(c.maxCoins(nums));
	}

	private int[][] cache = null;

	public int maxCoins(int[] nums) {
		int len = nums.length;
		int[] newArr = new int[len + 2];
		cache = new int[len + 2][len + 2];
		for (int i = 0; i < len + 2; i++) {
			for (int j = 0; j < len + 2; j++) {
				cache[i][j] = -1;
			}
		}
		newArr[0] = 1;
		newArr[len + 1] = 1;
		System.arraycopy(nums, 0, newArr, 1, len);
		return traversal(newArr, 0, len + 1);
	}

	public int traversal(int[] nums, int left, int right) {
		if (left >= right - 1) {
			return 0;
		}
		if (cache[left][right] != -1) {
			return cache[left][right];
		}
		int max = 0;
		for (int i = left + 1; i <= right - 1; i++) {
			int currentVal = nums[left] * nums[i] * nums[right];
			currentVal += traversal(nums, left, i);
			currentVal += traversal(nums, i, right);
			if (currentVal > max) {
				max = currentVal;
				cache[left][right] = max;
			}
		}
		return max;
	}

}
