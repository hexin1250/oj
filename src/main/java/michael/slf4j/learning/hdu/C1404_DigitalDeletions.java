package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1404_DigitalDeletions {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String s = sc.next();
				char[] ch = s.toCharArray();
				int step = 0;
				boolean zero = false;
				for (int i = 0; i < ch.length; i++) {
					int n = ch[i] - '0';
					if(n > 1) {
						step++;
					} else if(n == 0) {
						zero = true;
						break;
					}
				}
				if(!(step % 2 == 0 ^ zero)) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}

}
