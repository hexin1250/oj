package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1229 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int k = sc.nextInt();
				if(a == 0 && b == 0) {
					break;
				}
				int mod = 10;
				for (int i = 2; i <= k; i++) {
					mod *= 10;
				}
				if(a % mod == b % mod) {
					System.out.println(-1);
				} else {
					System.out.println(a + b);
				}
			}
		}
	}

}
