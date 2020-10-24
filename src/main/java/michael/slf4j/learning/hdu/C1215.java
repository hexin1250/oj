package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1215 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while (testcase-- > 0) {
				int n = sc.nextInt();
				int mid = (int) (Math.sqrt(n));
				int sum = 0;
				for (int i = 1; i <= mid; i++) {
					if(n % i == 0) {
						if(i != 1 && i != n && n / i != i) {
							sum += n / i;
						}
						sum += i;
					}
				}
				System.out.println(sum);
			}
		}
	}

}
