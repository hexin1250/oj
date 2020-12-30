package michael.slf4j.learning.hdu;

import java.math.BigDecimal;
import java.util.Scanner;

public class C1402_ABProblemPlus {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				BigDecimal a = new BigDecimal(sc.next());
				BigDecimal b = new BigDecimal(sc.next());
				System.out.println(a.multiply(b));
			}
		}
	}

}
