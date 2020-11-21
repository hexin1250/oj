package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1337_TheDrunkJailer {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				int sum = 1;
				for (int i = 2; i <= n; i++) {
					if(!divideN(i)) {
						sum++;
					}
				}
				System.out.println(sum);
			}
		}
	}
	
	private static boolean divideN(int n) {
		int sum = 0;
		for (int i = 2; i <= n / 2; i++) {
			if(n % i == 0) {
				sum++;
			}
		}
		return sum % 2 == 0;
	}

}
