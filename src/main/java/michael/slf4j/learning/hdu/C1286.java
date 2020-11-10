package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1286 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				int sum = 0;
				for (int i = 1; i < n; i++) {
					if(n % 2 == 0 && i % 2 == 0) {
						continue;
					}
					int gcd = gcd(i, n);
					if(gcd == 1) {
						sum++;
					}
				}
				System.out.println(sum);
			}
		}
	}
	
	public static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		else {
			return gcd(b, a % b);
		}
	}

}
