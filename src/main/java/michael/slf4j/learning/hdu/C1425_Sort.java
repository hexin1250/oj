package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;

public class C1425_Sort {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = sc.nextInt();
				}
				Arrays.sort(arr);
				StringBuffer sb = new StringBuffer();
				for (int i = m - 1; i >= 0; i--) {
					sb.append(arr[i + n - m]);
					if(i != 0) {
						sb.append(" ");
					}
				}
				System.out.println(sb);
			}
		}
	}

}
