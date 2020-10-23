package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1210 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				int index = 1;
				int init = 2;
				while(init != 1) {
					init = (init * 2) % (n * 2 + 1);
					index++;
				}
				System.out.println(index);
			}
		}
	}

}
