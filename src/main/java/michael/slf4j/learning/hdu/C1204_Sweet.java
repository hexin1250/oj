package michael.slf4j.learning.hdu;

import java.text.DecimalFormat;
import java.util.Scanner;

public class C1204_Sweet {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				int c = m + n;
				double p = sc.nextDouble();
				double q = sc.nextDouble();
				double x = p * (1 - q);// 能赢的概率
				double y = q * (1 - p);

				// 考虑特殊情况,先考虑糖果数量
				if (n == 0) {
					System.out.println("0.00");
					continue;
				}
				if (m == 0) {
					System.out.println("1.00");
					continue;
				}
				// 考虑特殊情况,再考虑获胜概率
				if (x == 0 || y == 1) {
					System.out.println("0.00");
					continue;
				}
				if (x == 1 || y == 0) {
					System.out.println("1.00");
					continue;
				}

				if (x == y) {
					DecimalFormat df = new DecimalFormat("0.00");
					// speakless先输光的概率
					double rate = 1.0 * m / c;
					String ret = df.format(1 - rate);
					// 故speakless赢的概率可知
					System.out.println(ret);
				} else {
					DecimalFormat df = new DecimalFormat("0.00");
					double rate = (Math.pow(y / x, n) - Math.pow(y / x, c)) / (1 - Math.pow(y / x, c));
					String ret = df.format(1 - rate);
					System.out.println(ret);
				}

			}
		}
	}

}
