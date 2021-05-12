package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1564 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				if (n == 0) {
					break;
				}
				System.out.println((n % 2 == 0 ? "8600" : "ailyanlu"));
			}
		}
	}

}
