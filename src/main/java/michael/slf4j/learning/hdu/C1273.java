package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1273 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				long n = sc.nextLong();
				if(n == 0) {
					break;
				}
				if(n <= 4) {
					System.out.println(1);
				} else {
					System.out.println((n - 1) * (n - 4) / 2);
				}
			}
		}
	}

}
