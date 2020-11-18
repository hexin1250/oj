package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1328_IBMMinusOne {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			for (int k = 1; k <= testcase; k++) {
				char[] ch = sc.next().toCharArray();
				System.out.println("String #" + k);
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < ch.length; i++) {
					if(ch[i] != 'Z') {
						sb.append((char)(ch[i] + 1));
					} else {
						sb.append('A');
					}
				}
				System.out.println(sb.toString());
				System.out.println();
			}
		}
	}

}
