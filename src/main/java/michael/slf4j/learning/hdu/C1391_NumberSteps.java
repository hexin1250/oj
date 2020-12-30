package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1391_NumberSteps {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				if(x - y != 2 && x != y) {
					System.out.println("No Number");
				} else if(x % 2 == 0) {
					System.out.println(x + y);
				} else {
					System.out.println(x + y - 1);
				}
			}
		}
	}

}
