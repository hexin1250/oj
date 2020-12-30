package michael.slf4j.learning.hdu;

import java.math.BigDecimal;
import java.util.Scanner;

public class C1376_OctalFractions {
	private static final BigDecimal DVD = new BigDecimal(8);

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				String source = sc.next();
				String[] parts = source.split("[.]");
				String digital = parts[1];
				int[] ch = getNumbers(digital);
				BigDecimal sum = new BigDecimal(0);
				for (int i = 1; i <= ch.length; i++) {
					BigDecimal bd = new BigDecimal(ch[i - 1]);
					for (int j = 0; j < i; j++) {
						bd = bd.divide(DVD);
					}
					sum = sum.add(bd);
				}
				System.out.println(source + " [8] = " + sum + " [10]");
			}
		}
	}

	private static int[] getNumbers(String digital) {
		int[] ret = new int[digital.length()];
		for (int i = 0; i < digital.length(); i++) {
			ret[i] = digital.charAt(i) - '0';
		}
		return ret;
	}

}
