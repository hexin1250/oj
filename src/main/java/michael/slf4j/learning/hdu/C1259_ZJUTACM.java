package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1259_ZJUTACM {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				int last = 2;
				for (int i = 0; i < n; i++) {
					int a = sc.nextInt();
					int b = sc.nextInt();
					int less = Math.min(a, b);
					int great = Math.max(a, b);
					if(less == last) {
						last = great;
					} else if(great == last) {
						last = less;
					}
				}
				System.out.println(last);
			}
		}
	}

}
