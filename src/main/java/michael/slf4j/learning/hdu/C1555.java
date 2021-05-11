package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1555 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int m = sc.nextInt();
				int k = sc.nextInt();
				if(m == 0 && k == 0) {
					break;
				}
				int days = 0;
				int time = 0;
				while(m > 0) {
					m--;
					time++;
					days++;
					if(time == k) {
						time = 0;
						m++;
					}
				}
				System.out.println(days);
			}
		}
	}

}
