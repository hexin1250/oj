package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1525_Euclids {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(a == 0 && b == 0) {
					break;
				}
				boolean win = true;
				while(true) {
					if(a < b) {
						a = a + b;
						b = a - b;
						a = a - b;
					}
					if(a >= 2 * b || a % b == 0) {
						break;
					}
					a = a - b;
					
					a = a + b;
					b = a - b;
					a = a - b;
					win = !win;
				}
				if(win) {
					System.out.println("Stan wins");
				} else {
					System.out.println("Ollie wins");
				}
			}
		}
	}

}
