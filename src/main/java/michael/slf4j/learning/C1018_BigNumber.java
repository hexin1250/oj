package michael.slf4j.learning;

import java.util.Scanner;

public class C1018_BigNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int i = 0; i < testcase; i++) {
			int n = sc.nextInt();
			double sum = 1D;
			int digital = 1;
			for (int j = 2; j <= n; j++) {
				sum *= j;
				while(sum >= 10D) {
					sum /= 10D;
					digital++;
				}
			}
			System.out.println(digital);
		}
		sc.close();
	}

}
