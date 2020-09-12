package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;

public class C2019_InsertOld {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			if(n == 0 && x == 0) {
				break;
			}
			int a[] = new int[n + 1];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			a[n] = x;
			Arrays.sort(a);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n + 1; i++) {
				if(i != 0) {
					sb.append(' ');
				}
				sb.append(a[i]);
			}
			System.out.println(sb.toString());
		}
		sc.close();
	}

}
