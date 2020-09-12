package michael.slf4j.learning;

import java.util.Scanner;

public class C1048_Hardest {
	private static final char[] ch = new char[] {'V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U'};

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				String line = sc.nextLine();
				if("START".equals(line) || "END".equals(line)) {
					continue;
				} else if("ENDOFINPUT".equals(line)) {
					break;
				}
				char[] arr = line.toCharArray();
				for (char c : arr) {
					if(c >= 'A' && c <= 'Z') {
						System.out.print(ch[c - 'A']);
					} else {
						System.out.print(c);
					}
				}
				System.out.println();
			}
		}
	}

}
