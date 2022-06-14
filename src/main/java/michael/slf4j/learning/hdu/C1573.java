package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1573 {

	private static long mod(long a, long b) {
		if(a % b == 0) {
			return b;
		} else {
			return mod(b, a% b);
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				long[] a = new long[m];
				long[] b = new long[m];
				for (int i = 0; i < m; i++) {
					a[i] = sc.nextInt();
				}
				for (int i = 0; i < m; i++) {
					b[i] = sc.nextInt();
				}
				for (int i = 0; i < m - 1; i++) {
					for (int j = i + 1; j < m; j++) {
						if(a[i] > a[j]) {
							long tmp = b[i];
							b[i] = b[j];
							b[j] = tmp;
							
							tmp = a[i];
							a[i] = a[j];
							a[j] = tmp;
						}
					}
				}
				long cycle = a[0];
				long mod = b[0];
				for (int i = 1; i < m; i++) {
					long newCycle = cycle * a[i] / (mod(cycle, a[i]));
					long newMod = -1;
					for (long j = 0; j <= a[i] && cycle * j <= newCycle; j++) {
						if((cycle * j + mod - b[i]) % a[i] == 0 && (cycle * j + mod >= 0)) {
							newMod = cycle * j + mod;
							break;
						}
					}
					mod = newMod;
					cycle = newCycle;
					if(mod == -1) {
						break;
					}
				}
				long ret = 0;
				if(mod != -1) {
					if(mod == 0) {
						mod = cycle;
					}
					if(mod <= n) {
						ret = 1 + (n - mod) / cycle;
					}
				}
				System.out.println(ret);
			}
		}
	}

}
