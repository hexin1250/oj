package michael.slf4j.learning.hdu;

import java.util.Scanner;

/**
 * Timeout
 * @author ch
 *
 */
public class C1058_HumbleNumbers {
	private static final int N = 5842;
	private static final long[] check = new long[] {2,3,5,7};
	private static long[] target = new long[N];
	
	static {
		for (int i = 1; i <= 10; i++) {
			target[i - 1] = i;
		}
		int index = 9;
		while(index < N - 1) {
			long min = Integer.MAX_VALUE;
			for (int i = index - 1; i >= 1; i--) {
				for (int j = 0; j < 4; j++) {
					long number = check[j] * target[i];
					if(number < min && number > target[index]) {
						min = number;
					}
				}
			}
			target[++index] = min;
		}
	}

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				if (n % 10 == 1 && n % 100 != 11)
					System.out.printf("The %dst humble number is %d.\r\n", n, target[n - 1]);
				else if (n % 10 == 2 && n % 100 != 12)
					System.out.printf("The %dnd humble number is %d.\r\n", n, target[n - 1]);
				else if (n % 10 == 3 && n % 100 != 13)
					System.out.printf("The %drd humble number is %d.\r\n", n, target[n - 1]);
				else
					System.out.printf("The %dth humble number is %d.\r\n", n, target[n - 1]);
			}
		}
	}

}
