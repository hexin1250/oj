package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C1176 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				Map<Integer, List<Integer>> map = new HashMap<>();
				int maxTime = 0;
				for (int i = 0; i < n; i++) {
					int point = sc.nextInt();
					int time = sc.nextInt();
					if(maxTime < time) {
						maxTime = time;
					}
					List<Integer> points = map.get(time);
					if(points == null) {
						points = new ArrayList<>();
					}
					points.add(point);
					map.put(time, points);
				}
				int[][] dp = new int[maxTime + 1][11];
				for (int i = 0; i < maxTime + 1; i++) {
					for (int j = 0; j < 11; j++) {
						dp[i][j] = -1;
					}
				}
				dp[0][5] = 0;
				for (int i = 1; i <= maxTime; i++) {
					for (int j = 0; j < 11; j++) {
						dp[i][j] = max(dp[i - 1], j);
					}
					List<Integer> points = map.get(i);
					if(points != null) {
						for (Integer point : points) {
							if(dp[i][point] != -1) {
								dp[i][point] += 1;
							}
						}
					}
				}
				System.out.println(Arrays.stream(dp[maxTime]).max().getAsInt());
			}
		}
	}
	
	private static int max(int[] arr, int mid) {
		int max = -1;
		for (int i = mid - 1 >= 0 ? mid - 1 : 0; i < 11 && i <= mid + 1; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}

}
