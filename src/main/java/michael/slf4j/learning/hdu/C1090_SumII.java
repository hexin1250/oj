package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1090_SumII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(sc.nextInt() + sc.nextInt());
		}
		sc.close();
	}

}
