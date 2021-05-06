package michael.slf4j.learning.hdu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C1508_Alphacode {
	private static Map<Integer, BigDecimal> cache = new HashMap<>();

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				String str = sc.next();
				if("0".equals(str)) {
					break;
				}
				List<Integer> list = new ArrayList<>();
				int start = 0;
				boolean possible = true;
				for (int i = 0; i < str.length(); i++) {
					int v = str.charAt(i) - '0';
					int length = i - start + 1;
					if(v == 0 || v >= 7) {
						start = i + 1;
						if(length > 1) {
							length--;
						} else if(v == 0) {
							possible = false;
							break;
						}
						list.add(length);
					} else if(v >= 3 && v <= 6) {
						list.add(length);
						start = i + 1;
					} else if(i == str.length() - 1) {
						list.add(length);
					}
				}
				if(!possible) {
					System.out.println(0);
				} else {
					BigDecimal bd = new BigDecimal(1);
					for (int v : list) {
						if(v > 1) {
							bd = bd.multiply(fibo(v));
						}
					}
					System.out.println(bd);
				}
			}
		}
	}
	
	private static BigDecimal fibo(int n) {
		if(n <= 3) {
			return new BigDecimal(n);
		}
		BigDecimal bd = cache.get(n);
		if(bd != null) {
			return bd;
		}
		BigDecimal n1 = fibo(n - 1);
		BigDecimal n2 = fibo(n - 2);
		bd = n1.add(n2);
		cache.put(n, bd);
		return bd;
	}

}
