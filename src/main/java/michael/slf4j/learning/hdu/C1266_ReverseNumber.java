package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1266_ReverseNumber {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			sc.nextLine();
			while(testcase-- > 0) {
				char[] ch = sc.nextLine().toCharArray();
				int startIndex = 0;
				StringBuffer sb = new StringBuffer();
				if(ch[0] == '-') {
					startIndex = 1;
					sb.append(ch[0]);
				}
				int endZero = ch.length;
				boolean start = false;
				for (int i = ch.length - 1; i >= startIndex; i--) {
					if(ch[i] == '0' && !start) {
						endZero = i;
						continue;
					} else {
						start = true;
					}
					sb.append(ch[i]);
				}
				for (int i = endZero; i < ch.length; i++) {
					sb.append('0');
				}
				System.out.println(sb.toString());
			}
		}
	}

}
