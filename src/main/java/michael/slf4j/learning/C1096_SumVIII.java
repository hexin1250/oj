package michael.slf4j.learning;

import java.util.Scanner;

public class C1096_SumVIII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += sc.nextInt();
			}
			if (i != 0) {
				System.out.println();
			}
			System.out.println(sum);
		}
		sc.close();
	}

}
