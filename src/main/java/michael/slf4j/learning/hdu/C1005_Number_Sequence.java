package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1005_Number_Sequence {
	private static int[] mem = new int[] { 1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a == 0 && b == 0 && c == 0) {
				break;
			}
			int[] arr = print(a, b, c);
			System.out.println(arr[0]);
		}
		sc.close();
	}

	public static int[] print(int a, int b, int c) {
		int[] retArr = new int[2];
		if (c == 1 || c == 2) {
			retArr[0] = 1;
			retArr[1] = 1;
		} else {
			int[] arr = new int[c + 1];
			int ret = -1;
			int target = -1;
			for (int i = 3; i <= c; i++) {
				ret = fib(i, a, b);
				arr[i] = ret;
				if (i >= 6) {
					if (arr[3] == arr[i] && arr[2] == arr[i - 1] && arr[1] == arr[i - 2]) {
						int length = i - 3;
						int times = (c - 3) % length;
						if (times == 0) {
							times = length;
						}
						ret = arr[times];
						target = arr[times];
						break;
					}
				}
			}
			retArr[0] = ret;
			retArr[1] = target;
		}
		mem[0] = 1;
		mem[1] = 1;
		return retArr;
	}

	private static int fib(int t, int a, int b) {
		if (t == 1 || t == 2) {
			return 1;
		}
		int ret = (mem[1] * a + mem[0] * b) % 7;
		mem[0] = mem[1];
		mem[1] = ret;
		return ret;
	}

}