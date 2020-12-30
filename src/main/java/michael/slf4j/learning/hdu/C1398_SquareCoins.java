package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1398_SquareCoins {
	private static int[] arr = new int[17];
	static {
		for (int i = 0; i < 17; i++) {
			arr[i] = (i + 1) * (i + 1);
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				if (n == 0) {
					break;
				}
				int start = 0;
				for (int i = 0; i < 17; i++) {
					if(arr[i] <= n) {
						start = i;
					} else {
						break;
					}
				}
				System.out.println(dfs(n, start));
			}
		}
	}

	private static int dfs(int n, int start) {
		if(start == 0) {
			return 1;
		}
		int ret = 0;
		for (int i = start; i >= 0; i--) {
			int c = n / arr[i];
			for (int j = c; j >= 1; j--) {
				int next = n - arr[i] * j;
				if(next == 0) {
					ret++;
				} else {
					ret += dfs(next, i - 1);
				}
			}
		}
		return ret;
	}

}
