package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1248 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while (testcase-- > 0) {
				int n = sc.nextInt();
				int mod = n % 50;
				int v = (n - mod) / 50;
				int values[] = {3, 4, 7};
				int weights[] = {3, 4, 7};
				int dp[] = new int[v + 1];
				for (int i = 0; i < 3; i++) {
					for (int j = values[i]; j <= v; j++) {
						dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
					}
				}
				System.out.println((v - dp[v]) * 50 + mod);
			}
		}
	}
}
