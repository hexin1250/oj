package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1406 {
	private static final int[] arr = new int[] {1,6,28,496,8128};

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				if(s > e) {
					int tmp = s;
					s = e;
					e = tmp;
				}
				int c = 0;
				for (int a : arr) {
					if(a <= e && a >= s) {
						c++;
					}
				}
				System.out.println(c);
			}
		}
	}

}
