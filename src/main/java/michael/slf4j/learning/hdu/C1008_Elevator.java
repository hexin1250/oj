package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1008_Elevator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			int sum = 0;
			int pre = 0;
			for (int i = 0; i < n; i++) {
				int f = sc.nextInt();
				sum += (f > pre) ? 6 * (f - pre) : 4 * (pre - f);
				sum += 5;
				pre = f;
			}
			System.out.println(sum);
		}
		sc.close();
	}

}
