package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;

public class C1158_Employment {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while (sc.hasNext()) {
				int month = sc.nextInt();
				if(month == 0) {
					break;
				}
				int hire = sc.nextInt();
				int salary = sc.nextInt();
				int fire = sc.nextInt();
				int[] w = new int[month];
				for (int i = 0; i < month; i++) {
					w[i] = sc.nextInt();
				}
				int max = Arrays.stream(w).max().getAsInt();
				int min = Arrays.stream(w).min().getAsInt();
				int length = max - min + 1;
				int[][] dp = new int[month][length];
				for (int i = 0; i < month; i++) {
					for (int j = 0; j < length; j++) {
						dp[i][j] = Integer.MAX_VALUE;
					}
				}
				for (int i = 0; i < length; i++) {
					dp[0][i] = (min + i) * (hire + salary);
				}
				for (int i = 1; i < month; i++) {
					for (int j = w[i] - min; j < length; j++) {
						for (int k = w[i - 1] - min; k < length; k++) {
							int value = k > j ? fire : hire;
							int currentRet = dp[i - 1][k] + Math.abs(k - j) * value + (j + min) * salary;
							dp[i][j] = Math.min(dp[i][j], currentRet);
						}
					}
				}
				System.out.println(Arrays.stream(dp[month - 1]).min().getAsInt());
			}
		}
	}

}
