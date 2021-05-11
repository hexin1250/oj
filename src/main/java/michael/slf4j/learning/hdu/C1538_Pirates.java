package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1538_Pirates {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while (testcase-- > 0) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				int index = sc.nextInt();
				int other = n % 2 == 0 ? n / 2 - 1 : n / 2;
				int minimal = n % 2 == 0 ? 2 : 1;
				if(m < other + 1) {
					minimal += (other + 1 - m) * 2;
					if(index < minimal) {
						System.out.println("Thrown");
					} else if((n - index) % 2 == 1) {
						System.out.println(0);
					} else {
						System.out.println(1);
					}
				} else {
					if((n - index) % 2 == 1) {
						System.out.println(0);
					} else if(n != index) {
						System.out.println(1);
					} else {
						System.out.println(m - other);
					}
				}
			}
		}
	}

}
