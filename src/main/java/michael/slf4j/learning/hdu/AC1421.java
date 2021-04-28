package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class AC1421 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNextInt()) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				int[] data = new int[n];
				for (int i = 0; i < n; i++) {
					data[i] = sc.nextInt();
				}

				Arrays.sort(data);

				System.out.println(getResult(data, n, m));
			}
		}
	}

	public static int getResult(int[] data, int n, int m) {
		int[][] dp = new int[2100][1100];
		for (int i = 1; i <= n; ++i) {
			Arrays.fill(dp[i], 9999999);
		}

		int[] a = new int[2100];
		for (int i = 1; i <= n - 1; ++i) {
			a[i] = data[i] - data[i - 1];
			a[i] *= a[i];
		}

		for (int i = 0; i <= n; ++i) {
			dp[i][0] = 0;
		}

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i / 2; ++j) {
				if (i == j * 2) {
					dp[i][j] = dp[i - 2][j - 1] + a[i - 1];
					continue;
				}
				dp[i][j] = Math.min(dp[i - 1][j], dp[i - 2][j - 1] + a[i - 1]);
			}
		}
		return dp[n][m];
	}
}