package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;

public class C1280 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = sc.nextInt();
				}
				int[] a = new int[n * (n - 1) / 2];
				int index = 0;
				for (int i = 0; i < n - 1; i++) {
					for (int j = i + 1; j < n; j++) {
						a[index++] = arr[i] + arr[j];
					}
				}
				Arrays.sort(a);
				for (int i = a.length - 1; i >= a.length - m; i--) {
					if(i != a.length - 1) {
						System.out.print(' ');
					}
					System.out.print(a[i]);
				}
				System.out.println();
			}
		}
	}

}
