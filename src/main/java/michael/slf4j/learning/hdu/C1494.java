package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;

public class C1494 {
	private static final int DP_MAX = 2100;
	private static final int MAX_VALUE = Integer.MAX_VALUE >> 4;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				int cycle = sc.nextInt();
				int[] normal = new int[n];
				int[] fast = new int[n];
				for (int i = 0; i < n; i++) {
					normal[i] = sc.nextInt();
				}
				for (int i = 0; i < n; i++) {
					fast[i] = sc.nextInt();
				}
				System.out.println(getDp(n, cycle, normal, fast));
			}
		}
	}

	public static int getDp(int n, int cycle, int[] normal, int[] fast) {
		if(n == 1) {
			int normalTime = normal[0];
			int fastTime = fast[0];
			int fastCycle = cycle / 5;
			if(fastCycle % 5 == 0 && fastCycle > 0) {
				fastCycle -= 1;
			}
			return fastCycle * fastTime + (cycle - fastCycle) * normalTime;
		}
		int[][] dp = new int[n][DP_MAX];
		int[][] energy = new int[n][DP_MAX];
		Arrays.stream(dp).parallel().forEach(nestDp -> {
			for (int i = 0; i < DP_MAX; i++) {
				nestDp[i] = MAX_VALUE;
			}});
		Arrays.stream(energy).parallel().forEach(nestDp -> {
			for (int i = 0; i < DP_MAX; i++) {
				nestDp[i] = MAX_VALUE;
			}});
		for (int i = 0; i < cycle; i++) {
			for (int j = 0; j < n; j++) {
				int lastPosition = getLastIndex(j, n);
				int lastTime = dp[lastPosition][0];
				int lastEnergy = energy[lastPosition][0];
				if(i == 0 && j == 0) {
					lastTime = 0;
					lastEnergy = 0;
				}
				
				dp[j][0] = lastTime + normal[j];
				energy[j][0] = lastEnergy + 1;
				if(energy[j][0] == 15) {
					energy[j][0] = 10;
				}
				/**
				 * calculate dp array.
				 */
				for (int k = 1; k < DP_MAX; k++) {
					if(dp[lastPosition][k - 1] >= MAX_VALUE && dp[lastPosition][k] >= MAX_VALUE) {
						break;
					}
					if(energy[lastPosition][k - 1] >= 5) {
						int lastNormalTime = dp[lastPosition][k - 1];
						int lastNormalEnergy = energy[lastPosition][k - 1];
						int lastFastTime = dp[lastPosition][k];
						int lastFastEnergy = energy[lastPosition][k];
						if(lastFastTime >= MAX_VALUE || lastNormalTime + fast[j] < lastFastTime + normal[j]) {
							dp[j][k] = lastNormalTime + fast[j];
							energy[j][k] = lastNormalEnergy - 5;
						} else {
							dp[j][k] = lastFastTime + normal[j];
							energy[j][k] = lastFastEnergy + 1;
							if(energy[j][k] == 15) {
								energy[j][k] = 10;
							}
						}
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < DP_MAX; i++) {
			min = Math.min(min, dp[n - 1][i]);
		}
		return min;
	}
	
	private static int getLastIndex(int position, int n) {
		if(position == 0) {
			return n - 1;
		}
		return position - 1;
	}

}
