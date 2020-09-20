package michael.slf4j.learning.hdu;

import java.math.BigInteger;
import java.util.Scanner;

public class AC1130 {
	// 卡特兰数
	// h(n)=h(n-1)*(4*n-2)/(n+1);
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger h[] = new BigInteger[1005];
		h[0] = new BigInteger("1");
		h[1] = new BigInteger("1");
		BigInteger one = new BigInteger("1");
		BigInteger four = new BigInteger("4");
		BigInteger two = new BigInteger("2");
		for (int i = 2; i < 1005; i++) {
			String str = String.valueOf(i);
			BigInteger n = new BigInteger(str);
			h[i] = (n.multiply(four).subtract(two)).multiply(h[i - 1]).divide(n.add(one));
		}
		while (in.hasNext()) {
			int n = in.nextInt();
			System.out.println(h[n]);
		}
		in.close();
	}
}