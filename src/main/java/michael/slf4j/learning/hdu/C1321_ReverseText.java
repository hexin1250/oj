package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1321_ReverseText {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			sc.nextLine();
			while (testcase-- > 0) {
				String line = sc.nextLine();
				char[] ch = line.toCharArray();
				StringBuffer sb = new StringBuffer();
				for (int i = ch.length - 1; i >= 0; i--) {
					sb.append(ch[i]);
				}
				System.out.println(sb.toString());
			}
		}
	}

}
