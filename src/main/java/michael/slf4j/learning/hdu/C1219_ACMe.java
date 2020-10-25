package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1219_ACMe {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				String line = sc.nextLine();
				char[] ch = line.toCharArray();
				int[] ret = new int[26];
				for (int i = 0; i < ch.length; i++) {
					if(ch[i] <= 'z' && ch[i] >= 'a') {
						int index = ch[i] - 'a';
						ret[index]++;
					}
				}
				for (int i = 0; i < ret.length; i++) {
					char c = (char) ('a' + i);
					System.out.println(c + ":" + ret[i]);
				}
				System.out.println();
			}
		}
	}

}
