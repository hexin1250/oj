package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C2027_Statistics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= testcase; i++) {
			if(i != 1) {
				System.out.println();
			}
			String line = sc.nextLine();
			char[] ch = line.trim().toLowerCase().toCharArray();
			int countA = 0;
			int countE = 0;
			int countI = 0;
			int countO = 0;
			int countU = 0;
			for (int j = 0; j < ch.length; j++) {
				if(ch[j] == 'a') {
					countA++;
				} else if(ch[j] == 'e') {
					countE++;
				} else if(ch[j] == 'i') {
					countI++;
				} else if(ch[j] == 'o') {
					countO++;
				} else if(ch[j] == 'u') {
					countU++;
				}
			}
			System.out.println("a:" + countA);
			System.out.println("e:" + countE);
			System.out.println("i:" + countI);
			System.out.println("o:" + countO);
			System.out.println("u:" + countU);
		}
		sc.close();
	}

}
