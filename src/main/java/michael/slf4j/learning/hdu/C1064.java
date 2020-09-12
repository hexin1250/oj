package michael.slf4j.learning.hdu;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class C1064 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		while (sc.hasNext()) {
			double sum = 0D;
			double a = 0D;
			for (int i = 0; i < 12; i++) {
				a = sc.nextDouble();
				sum += a;
			}
			System.out.println(String.format("$%.2f", sum / 12D));
		}
		sc.close();
	}
}