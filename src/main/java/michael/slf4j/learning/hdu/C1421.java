package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;

public class C1421 {
	private static final long MY_MAX = 2L << 30;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				int k = sc.nextInt();
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = sc.nextInt();
				}
				Arrays.sort(arr);
				System.out.println(getResult(arr, n, k));
			}
		}
	}

	public static long getResult(int[] arr, int n, int k) {
		long[][] dp = new long[n][k];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], MY_MAX);
		}
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i - 1][0], (arr[i] - arr[i - 1]) * (arr[i] - arr[i - 1]));
		}
		for (int i = 3; i < n; i++) {
			for (int j = 1; j < k; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i - 2][j - 1] + (arr[i] - arr[i - 1]) * (arr[i] - arr[i - 1]));
			}
		}
		return dp[n - 1][k - 1];
	}

}
