package michael.slf4j.learning;

import java.util.Scanner;

public class C1081_MaxSumRe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(maxRe(n, arr));
		}
		sc.close();
	}

	public static int maxRe(int n, int[][] arr) {
		int max = arr[0][0];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = j; k < n; k++) {
					int ret = calc(arr, n, i, j, k);
					max = Math.max(max, ret);
				}
			}
		}
		return max;
	}

	private static int calc(int[][] arr, int n, int rowStart, int colStart, int colEnd) {
		int sum = 0;
		int max = arr[rowStart][colStart];
		for (int i = rowStart; i < n; i++) {
			for (int j = colStart; j <= colEnd; j++) {
				sum += arr[i][j];
			}
			if(sum < 0) {
				return max;
			}
			if(sum > max) {
				max = sum;
			}
		}
		return max;
	}

}
