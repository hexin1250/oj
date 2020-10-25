package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1222_GCD {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while (testcase-- > 0) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				if(gcd(m, n) == 1) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			}
		}
	}
	
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

}
