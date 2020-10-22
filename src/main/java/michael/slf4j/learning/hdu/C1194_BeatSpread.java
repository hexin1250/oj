package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1194_BeatSpread {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int t = sc.nextInt();
			while(t-- > 0) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				int a = x + y;
				if(a % 2 != 0) {
					System.out.println("impossible");
				} else {
					a /= 2;
					int b = x - a;
					if(Math.min(a, b) < 0) {
						System.out.println("impossible");
					} else {
						System.out.println(Math.max(a, b) + " " + Math.min(a, b));
					}
				}
			}
		}
	}

}
