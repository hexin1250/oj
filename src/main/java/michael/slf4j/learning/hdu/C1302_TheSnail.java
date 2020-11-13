package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1302_TheSnail {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				double h = n;
				double u = sc.nextInt();
				double d = sc.nextInt();
				double f = sc.nextInt();
				double cu = u + u * f / 100;
				int days = 1;
				double position = 0D;
				while(true) {
					cu -= u * f / 100;
					position += cu;
					if(position > h) {
						break;
					}
					position -= d;
					if(position < 0D) {
						break;
					}
					days++;
				}
				if(position <= 0D) {
					System.out.println("failure on day " + days);
				} else {
					System.out.println("success on day " + days);
				}
			}
		}
	}

}
