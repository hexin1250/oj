package michael.slf4j.learning;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class C1019_CommonMultiple {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		while (testcase-- > 0) {
			int count = sc.nextInt();
			Map<Integer, Integer> finalMap = new HashMap<>();
			for (int i = 0; i < count; i++) {
				int tmp = sc.nextInt();
				int init = 2;
				int previous = 0;
				int times = 0;
				while (tmp > 1) {
					if (tmp % init == 0) {
						times++;
						tmp /= init;
						previous = init;
					} else {
						if (previous > 0) {
							Integer max = finalMap.get(previous);
							if (max == null || max < times) {
								finalMap.put(previous, times);
							}
							previous = 0;
							times = 0;
						} else {
							if(init > Math.sqrt(tmp)) {
								Integer max = finalMap.get(tmp);
								if (max == null) {
									finalMap.put(tmp, 1);
								}
								break;
							}
						}
						init++;
					}
				}
				if (previous > 0) {
					Integer max = finalMap.get(previous);
					if (max == null || max < times) {
						finalMap.put(previous, times);
					}
					previous = 0;
					times = 0;
				}
			}
			BigDecimal sum = new BigDecimal(1L);
			for (Entry<Integer, Integer> entry : finalMap.entrySet()) {
				int number = entry.getKey();
				int times = entry.getValue();
				for (int i = 0; i < times; i++) {
					sum = sum.multiply(new BigDecimal(number));
				}
			}
			System.out.println(sum.longValue());
		}
		sc.close();
	}

}