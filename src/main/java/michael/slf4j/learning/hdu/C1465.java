package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C1465 {
	private static Map<Long, Long> mem = new HashMap<>();

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				long n = sc.nextLong();
				System.out.println(d(n));
			}
		}
	}
	
	private static long d(long n) {
		if(n <= 0) {
			return 0;
		} else if(n == 1) {
			return 0;
		} else if(n == 2) {
			return 1;
		}
		Long ret = mem.get(n);
		if(ret != null) {
			return ret;
		}
		long value = (n - 1) * (d(n - 1) + d(n - 2));
		mem.put(n, value);
		return value;
	}

}
