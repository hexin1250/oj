package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1257_DP {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				int[] a = new int[n];
				int[] dp = new int[n];
				int min = 0;
				for (int i = 0; i < n; i++) {
					a[i] = sc.nextInt();
					dp[i] = 1;
					for (int j = 0; j < i; j++) {
						if(a[j] < a[i]) {
							dp[i] = Math.max(dp[i], dp[j] + 1);
						}
					}
					min = Math.max(min, dp[i]);
				}
				System.out.println(min);
			}
		}
	}

}
