package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1420_NewAcmer {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while (testcase-- > 0) {
				long a = sc.nextLong();
				long b = sc.nextLong();
				long c = sc.nextLong();
				
				long d = a;
				long e = a;
				for (long i = 0; i < b; i++) {
					d = a % c;
					a = d * e;
				}
				System.out.println(d);
			}
		}
	}

}
