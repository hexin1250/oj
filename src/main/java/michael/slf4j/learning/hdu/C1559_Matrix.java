package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1559_Matrix {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				int[][] data = new int[m][n];
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						data[i][j] = sc.nextInt();
					}
				}
				int[][] ret = new int[m - x][n - y];
				for (int j = y; j < n; j++) {
					int sum = 0;
					for (int k = 0; k < x; k++) {
						for (int l = j - y; l < j; l++) {
							sum += data[k][l];
						}
					}
					ret[0][j - y] = sum;
				}
				for (int i = x + 1; i < m; i++) {
					for (int j = y; j < n; j++) {
						int sum = ret[i - x - 1][j - y];
						for (int l = j - y; l < j; l++) {
							sum -= data[i - x - 1][l];
						}
						for (int l = j - y; l < j; l++) {
							sum += data[i - 1][l];
						}
						ret[i - x][j - y] = sum;
					}
				}
				
				int max = 0;
				for (int[] embed : ret) {
					for (int v : embed) {
						if(max < v) {
							max = v;
						}
					}
				}
				System.out.println(max);
			}
		}
	}

}
