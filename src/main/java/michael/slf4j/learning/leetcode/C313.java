package michael.slf4j.learning.leetcode;

import java.util.Arrays;

public class C313 {

	public static void main(String[] args) {
		C313 c = new C313();
		int[] primes = new int[] { 2, 7, 13, 19 };
		System.out.println(c.nthSuperUglyNumber(12, primes));
	}

	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] dp = new int[n + 1];
		int m = primes.length;
		int[] pointers = new int[m];
		int[] nums = new int[m];
		Arrays.fill(nums, 1);
		for (int i = 1; i <= n; i++) {
			int minNum = Arrays.stream(nums).min().getAsInt();
			dp[i] = minNum;
			for (int j = 0; j < m; j++) {
				if (nums[j] == minNum) {
					pointers[j]++;
					nums[j] = dp[pointers[j]] * primes[j];
					System.out.println("\t" + j + ":" + nums[j] + "," + pointers[j] + "," + primes[j]);
				}
			}
		}
		return dp[n];
	}
}