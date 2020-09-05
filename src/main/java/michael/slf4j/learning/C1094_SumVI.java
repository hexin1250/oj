package michael.slf4j.learning;

import java.util.Scanner;

public class C1094_SumVI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += sc.nextInt();
			}
			System.out.println(sum);
		}
		sc.close();
	}

}
