package michael.slf4j.learning.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C368 {

	public static void main(String[] args) {
		C368 c = new C368();
//		int[] nums = new int[] {1,2,3};
		int[] nums = new int[] {1,2,4,5,15,16,32,40,64,128,256,512,1024,1024*2,1024*4,1024*8,1024*16,1024*32,1024*64,1024*128,1024*256,1024*512,1024*1024,1024*1024*2};
		System.out.println(c.largestDivisibleSubset(nums));
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		int[][] dp = new int[len][2];
		dp[0][0] = -1;
		dp[0][1] = 0;
		int max = 0;
		int index = 0;
		for (int i = 1; i < len; i++) {
			int num = nums[i];
			dp[i][0] = -1;
			dp[i][1] = 0;
			int currentMax = -1;
			for (int j = i - 1; j >= 0; j--) {
				int[] prevDp = dp[j];
				if(num % nums[j] == 0 && (currentMax == -1 || currentMax < prevDp[1])) {
					dp[i][0] = j;
					currentMax = prevDp[1];
				}
			}
			if(dp[i][0] != -1) {
				dp[i][1] = currentMax + 1;
				if(dp[i][1] > max) {
					max = dp[i][1];
					index = i;
				}
			}
		}
		List<Integer> ret = new ArrayList<Integer>(max);
		while(index != -1) {
			int num = nums[index];
			ret.add(0, num);
			index = dp[index][0];
		}
		return ret;
	}

}
