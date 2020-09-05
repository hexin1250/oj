package michael.slf4j.learning;

import java.util.Scanner;

public class C1092_SumIV {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += sc.nextInt();
			}
			System.out.println(sum);
		}
		sc.close();
	}

}
