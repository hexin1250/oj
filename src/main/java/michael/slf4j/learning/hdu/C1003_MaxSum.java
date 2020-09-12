package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1003_MaxSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			int[] arr = new int[m];
			for (int j = 0; j < m; j++) {
				arr[j] = sc.nextInt();
			}
			if (i != 0) {
				System.out.println();
			}
			System.out.println("Case " + (i + 1) + ":");
			print(arr);
		}
		sc.close();
	}

	public static void print(int[] arr) {
		int start = 0, end = 0;
		int tmpStart = 0;
		int max = arr[0];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > max) {
				max = sum;
				start = tmpStart;
				end = i;
			}
			if (sum < 0) {
				sum = 0;
				tmpStart = i + 1;
			}
		}
		System.out.println(max + " " + (start + 1) + " " + (end + 1));
	}

}