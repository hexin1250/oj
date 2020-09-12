package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;

public class C2000_AsciiSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			char[] a = line.toCharArray();
			Arrays.sort(a);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < a.length; i++) {
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
