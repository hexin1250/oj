package michael.slf4j.learning.hdu;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C1250_HatFibonacciBigDecimal {
	private static Map<Integer, BigDecimal> map = new HashMap<>();
	
	static {
		map.put(1, new BigDecimal(1));
		map.put(2, new BigDecimal(1));
		map.put(3, new BigDecimal(1));
		map.put(4, new BigDecimal(1));
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				System.out.println(getResult(n).toString());
			}
		}
	}
	
	public static BigDecimal getResult(int n) {
		BigDecimal ret = map.get(n);
		if(ret != null) {
			return ret;
		}
		BigDecimal part1 = getResult(n - 1).add(getResult(n - 2));
		BigDecimal part2 = getResult(n - 3).add(getResult(n - 4));
		ret = part1.add(part2);
		map.put(n, ret);
		return ret;
	}

}
