package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1039_EasierSaid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			if("end".equals(line)) {
				break;
			}
			char[] ch = line.toCharArray();
			boolean vowel = false;
			int consonants = 0;
			int vowels = 0;
			boolean acceptable = true;
			for (int i = 0; i < ch.length; i++) {
				char c = ch[i];
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					vowel = true;
					if(consonants > 0) {
						vowels = 1;
						consonants = 0;
					} else {
						vowels++;
					}
				} else {
					if(vowels > 0) {
						vowels = 0;
						consonants = 1;
					} else {
						consonants++;
					}
				}
				if(consonants == 3 || vowels == 3) {
					acceptable = false;
					break;
				}
				if(i != 0 && ch[i] == ch[i - 1] && (c != 'e' && c != 'o')) {
					acceptable = false;
					break;
				}
			}
			acceptable = acceptable && vowel;
			if(acceptable) {
				System.out.printf("<%s> is acceptable.\r\n", line);
			} else {
				System.out.printf("<%s> is not acceptable.\r\n", line);
			}
		}
		sc.close();
	}

}
