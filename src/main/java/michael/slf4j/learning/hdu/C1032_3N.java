package michael.slf4j.learning.hdu;

import java.math.BigDecimal;
import java.util.Scanner;

public class C1032_3N {
	private static long[] mem = new long[1000001];
	
	static {
		mem[1] = 1L;
		mem[2] = 2L;
		for (int i = 3; i <= 1_000_000; i++) {
			BigDecimal b = new BigDecimal(i);
			mem[i] = getLen(b);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int lower = Math.min(n, m);
			int larger = Math.max(n, m);
			long max = mem[lower];
			for (int i = lower + 1; i <= larger; i++) {
				long currentLength = mem[i];
				if(currentLength > max) {
					max = currentLength;
				}
			}
			System.out.printf("%d %d %d\r\n", n, m, max);
		}
		sc.close();
	}
	
	private static long getLen(BigDecimal b) {
		long n = b.longValue();
		if(b.longValue() <= 1_000_000L) {
			if(mem[b.intValue()] > 0) {
				return mem[b.intValue()];
			}
			if(n % 2 == 0) {
				mem[b.intValue()] = getLen(new BigDecimal(n / 2)) + 1;
			} else {
				mem[b.intValue()] = getLen(new BigDecimal(n * 3 + 1)) + 1;
			}
			return mem[b.intValue()];
		} else {
			if(n % 2 == 0) {
				return getLen(new BigDecimal(n / 2)) + 1;
			} else {
				return getLen(new BigDecimal(n * 3 + 1)) + 1;
			}
		}
	}

}
