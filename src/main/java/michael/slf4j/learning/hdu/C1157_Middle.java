package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;

public class C1157_Middle {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while (sc.hasNext()) {
				int n = sc.nextInt();
				int[] a = new int[n];
				for (int i = 0; i < n; i++) {
					a[i] = sc.nextInt();
				}
				Arrays.sort(a);
				System.out.println(a[a.length / 2]);
			}
		}
	}

}
