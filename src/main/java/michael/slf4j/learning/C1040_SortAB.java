package michael.slf4j.learning;

import java.util.Arrays;
import java.util.Scanner;

public class C1040_SortAB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int i = 0; i < testcase; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < n; j++) {
				if(j != 0) {
					sb.append(' ');
				}
				sb.append(arr[j]);
			}
			System.out.println(sb.toString());
		}
		sc.close();
	}

}
