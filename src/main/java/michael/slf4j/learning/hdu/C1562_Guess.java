package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1562_Guess {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while (testcase-- > 0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				int ret = -1;
				for (int i = 1000; i <= 9999; i++) {
					if(i % a == 0 && (i + 1) % b == 0 && (i + 2) % c == 0) {
						ret = i;
						break;
					}
				}
				if(ret == -1) {
					System.out.println("Impossible");
				} else {
					System.out.println(ret);
				}
			}
		}
	}

}
