package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1288 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				if(n == 0 && a == 0 && b == 0 && c == 0) {
					break;
				}
				
				if((n % 5 > a && b > 0) || (n % 10 > a && b == 0) || (a + 5 * b + 10 * c < n)) {
					System.out.println("Hat cannot buy tea.");
					continue;
				}
				if(a == 0 && b == 0 && n % 10 > 0) {
					System.out.println("Hat cannot buy tea.");
					continue;
				}
				int ta = 0;
				int tb = 0;
				int tc = 0;
				if(b == 0) {
					ta = n % 10;
					a -= (n % 10);
					n -= (n % 10);
					if(a % 10 > 0) {
						a -= (a % 10);
					}
					ta += n > a ? a : n;
					n -= n > a ? a : n;
					
					if(n / 10 > c) {
						System.out.println("Hat cannot buy tea.");
						continue;
					}
					tc = n / 10;
					n -= tc * 10;
				} else {
					ta = n % 5;
					a -= (n % 5);
					n -= (n % 5);
					if(a % 5 > 0) {
						a -= (a % 5);
					}
					ta += n > a ? a : n;
					n -= n > a ? a : n;
					
					tb = n / 5 > b ? b : n / 5;
					n -= tb * 5;
					b -= tb;
					if(n % 10 != 0) {
						tb -= 1;
						b += 1;
						n += 5;
					}
					if(n / 10 > c) {
						System.out.println("Hat cannot buy tea.");
						continue;
					}
					tc = n / 10;
					n -= tc * 10;
				}
				if(a < 0 || b < 0 || c < 0 || n > 0) {
					System.out.println("Hat cannot buy tea.");
				} else {
					System.out.println(ta + " YiJiao, " + tb + " WuJiao, and " + tc + " ShiJiao");
				}
			}
		}
	}

}
