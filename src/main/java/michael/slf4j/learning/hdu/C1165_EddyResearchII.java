package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1165_EddyResearchII {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				long m = sc.nextInt();
				long n = sc.nextInt();
				System.out.println(f(m,n));
			}
		}
	}

	private static long f(long m, long n) {
		long value;
		if(m == 0) {
			value = n + 1;
		} else if(m == 1) {
			value = n + m + 1;
		} else if(n == 0) {
			value = f(m - 1, 1);
		} else if(m == 2) {
			value = 3 + n * 2;
		} else {
			value = f(m - 1, f(m, n - 1));
		}
		return value;
	}

}
