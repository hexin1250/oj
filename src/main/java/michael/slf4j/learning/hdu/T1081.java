package michael.slf4j.learning.hdu;

import java.util.Random;

public class T1081 {

	public static void main(String[] args) {
		Random r = new Random();
		int n = r.nextInt(3) + 4;
		System.out.println(n);
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = r.nextInt(21) - 10;
				if(j != 0) {
					System.out.print(' ');
				}
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(C1081_MaxSumRe.maxRe(n, arr));
	}

}
