package michael.slf4j.learning;

import java.util.Scanner;

public class C1001_N {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			long n = sc.nextLong();
			System.out.println((n * (n + 1) / 2));
			System.out.println();
		}
		sc.close();
	}

}
