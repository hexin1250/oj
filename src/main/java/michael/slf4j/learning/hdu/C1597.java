package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1597 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				long m = sc.nextLong();
				long ret = getNumber(m);
				System.out.println(ret);
			}
		}
	}
	
	public static long getNumber(long m) {
		if(m == 1L) {
			return 1;
		}
		long max = 65536;
		long min = 1;
		long current = -1L;
		long number = -1L;
		boolean isSame = false;
		while(true) {
			current = (min + max) / 2;
			number = current * (current + 1) / 2;
			if(number == m) {
				isSame = true;
				break;
			}
			if(m > number) {
				min = current;
			} else {
				max = current;
			}
			if(max - min == 1) {
				current = min;
				number = min * (min + 1) / 2;
				break;
			}
		}
		long ret = -1;
		if(isSame) {
			ret = current % 9;
			if(ret == 0) {
				ret = 9;
			}
		} else {
			long mod = current;
			if(mod > 9) {
				mod = 9;
			}
			ret = (m - number) % mod;
			if(ret == 0) {
				ret = mod;
			}
		}
		return ret;
	}

}
