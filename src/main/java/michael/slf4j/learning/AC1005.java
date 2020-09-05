package michael.slf4j.learning;

import java.util.Scanner;

public class AC1005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int n = sc.nextInt();
			if (A != 0 && B != 0 && n != 0)
				System.out.println(f(n, A, B));
			else
				break;
		}
		sc.close();
	}
	
	public static int f(int n, int A, int B) {
//		mod 7 到最后只有49种可能，如果不加这个会导致内存超出限制
		if (n > 49) {
			n %= 49;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return ((A * f(n - 1, A, B) + B * f(n - 2, A, B)) % 7);
	}

}