package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1066_LastNonZeroDigit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			print(n);
		}
		sc.close();
	}
	
	public static void print(int n) {
		if(n == 0 || n == 1) {
			System.out.println(1);
		} else {
			System.out.println(multiplyResult(n));
		}
	}
	
	private static int multiplyResult(int n) {
		int sum = 1;
		for (int i = 2; i <= n; i++) {
			if(i % 10 == 0) {
				continue;
			}
			sum *= sum * (i % 10);
			sum = sum % 10;
		}
		return sum;
	}

}
