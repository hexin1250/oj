package michael.slf4j.learning;

import java.util.Scanner;

public class C1088_HTMLBrowser {
	private final static String BR = "<br>";
	private final static String HR = "<hr>";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = 0;
		while(sc.hasNext()) {
			String line = sc.nextLine().trim();
			if(line.length() == 0) {
				continue;
			}
			String[] parts = line.split("[\\s]+");
			for (String s : parts) {
				if(BR.equals(s)) {
					l = 0;
					System.out.println();
				} else if(HR.equals(s)) {
					if(l != 0) {
						l = 0;
						System.out.println();
					}
					for (int i = 0; i < 80; i++) {
						System.out.print('-');
					}
					System.out.println();
				} else {
					if(l == 0) {
						System.out.print(s);
						l = s.length();
					} else {
						int wordL = s.length();
						if(wordL + l + 1 <= 80) {
							System.out.print(' ');
							System.out.print(s);
							l = wordL + l + 1;
						} else {
							System.out.println();
							System.out.print(s);
							l = s.length();
						}
					}
				}
			}
		}
		System.out.println();
		sc.close();
	}

}
