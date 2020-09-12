package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class AC1028 {

	public static void main(String[] args) {
		int[] a = new int[121];
		a[120] = 0;
		a[0] = 1;
		for (int i = 1; i <= 120; i++) {
			for (int j = 0; j <= 120; j++) {
				if (a[j] != 0 && i + j < 121) {
					a[i + j] += a[j];
				}
			}
		}
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(a[n]);
		}
		sc.close();
	}

}
