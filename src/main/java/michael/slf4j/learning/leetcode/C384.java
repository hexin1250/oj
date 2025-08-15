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
	        int n = staging.length;
	        for (int i = 0; i < n - 1; i++) {
	        	/**
	        	 * r.nextInt(n - i) + i就是相当于在[i, n)
	        	 * 这里i从0开始
	        	 */
				int swapIndex = r.nextInt(n - i) + i;
				int tmp = staging[i];
				staging[i] = staging[swapIndex];
				staging[swapIndex] = tmp;
			}
	        return staging;
	    }
	}

}
