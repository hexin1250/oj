package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1570 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				String ch = sc.next();
				int n = sc.nextInt();
				int m = sc.nextInt();
				int sum = 1;
				for (int i = 1; i <= n; i++) {
					sum *= i;
				}
				for (int i = 1; i <= n - m; i++) {
					sum /= i;
				}
				switch(ch) {
				case "A":
					break;
					default:
						for (int i = 1; i <= m; i++) {
							sum /= i;
						}
				}
				if(sum == 0) {
					sum = 1;
				}
				System.out.println(sum);
			}
		}
	}

}
