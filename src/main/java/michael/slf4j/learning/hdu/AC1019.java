package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class AC1019 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			while (sc.hasNextInt()) {
				int n = sc.nextInt();

				for (int i = 0; i < n; i++) {
					int count = sc.nextInt();
					long a = sc.nextLong();
					if (a == 0) {
						System.out.println(0);
						continue;

					}
					int flag = 1;
					for (int j = 1; j < count; j++) {
						long b = sc.nextInt();
						if (b == 0) {
							System.out.println(0);
							flag = 0;
							break;
						}
						a = min(a, b);
					}
					if (flag == 1)
						System.out.println(a);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static long min(long a, long b) {
		long a1 = a, b1 = b;
		do {
			if (a % b == 0) {
				break;
			} else {
				long temp = a;
				a = b;
				b = temp % b;
			}
		} while (b != 0);
		return a1 * b1 / b;
	}
}