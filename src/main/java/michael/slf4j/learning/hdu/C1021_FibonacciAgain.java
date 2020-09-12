package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1021_FibonacciAgain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			if(n % 4 == 2) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		sc.close();
	}

}
