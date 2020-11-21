package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1339_ASimpleTask {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				int p = 0;
				while(n % 2 == 0) {
					n = n / 2;
					p++;
				}
				System.out.println(n + " " + p);
			}
		}
	}

}
