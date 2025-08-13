package michael.slf4j.learning.leetcode;

import java.util.Random;

public class C384 {

	public static void main(String[] args) {
	}
	public static class Solution{
		private int[] nums;
		private int[] staging;
		private Random r;
		public Solution(int[] nums) {
	        this.nums = nums;
	        staging = new int[nums.length];
	        System.arraycopy(nums, 0, staging, 0, nums.length);
	        this.r = new Random();
	    }
	    
	    public int[] reset() {
	        return nums;
	    }
	    
	    public int[] shuffle() {
	        int len = staging.length;
	        for (int i = 0; i < len - 1; i++) {
				int swapIndex = r.nextInt(len - i) + i;
				int tmp = staging[i];
				staging[i] = staging[swapIndex];
				staging[swapIndex] = tmp;
			}
	        return staging;
	    }
	}

}
