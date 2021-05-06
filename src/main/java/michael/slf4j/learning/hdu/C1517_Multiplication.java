package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1517_Multiplication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				double n = sc.nextDouble();
				while(n > 18) {
					n /= 18;
				}
				if(n <= 9) {
					System.out.println("Stan wins.");
				} else {
					System.out.println("Ollie wins.");
				}
			}
		}
	}

}
