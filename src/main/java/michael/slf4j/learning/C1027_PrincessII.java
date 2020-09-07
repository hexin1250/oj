package michael.slf4j.learning;

import java.util.Scanner;

public class C1027_PrincessII {
	private static final int F[] = new int[] {1, 1, 2, 6, 24, 120, 720, 5040};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int start = 0;
			if(n > 8) {
				for (int i = 1; i <= n - 8; i++) {
					if(i != 1) {
						System.out.print(' ');
					}
					System.out.print(i);
				}
				start = n - 7;
			}
		}
		sc.close();
	}

}
