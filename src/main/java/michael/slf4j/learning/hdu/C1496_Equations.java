package michael.slf4j.learning.hdu;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class C1496_Equations {
	
	private static Set<Integer> cache = new TreeSet<>();
	private static Map<Integer, Integer> map = new TreeMap<>();
	
	static {
		int lastV = 0;
		for (int i = 1; i <= 100; i++) {
			int ret = i * i;
			cache.add(ret);
			for (int j = lastV + 1; j <= ret; j++) {
				map.put(j, i);
			}
			lastV = ret;
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int[] params = new int[4];
				int lastValue = 0;
				boolean same = true;
				for (int i = 0; i < 4; i++) {
					params[i] = sc.nextInt();
					if(same) {
						if(lastValue == 0) {
							lastValue = params[i];
						} else {
							lastValue *= params[i];
							if(lastValue < 0) {
								same = false;
							}
							lastValue = params[i];
						}
					}
				}
				if(same) {
					System.out.println(0);
				} else {
					System.out.println(getSet(params, -1, true, 0, 0));
				}
			}
		}
	}
	
	private static int getSet(int[] params, int start, boolean isPositive, int positiveSum, int negativeSum) {
		int position = nextNum(params, start, isPositive);
		int nextPosition = nextNum(params, position, isPositive);
		int offset = positiveSum - negativeSum;
		if(nextPosition == -1 && !isPositive) {
			if(cache.contains(offset)) {
				return 16;
			} else {
				return 0;
			}
		}
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			int nextPositiveSum = positiveSum;
			int nextNegativeSum = negativeSum;
			int value = i * i * Math.abs(params[position]);
			int ret = 0;
			if(isPositive) {
				nextPositiveSum += value;
				boolean nextPositive = isPositive;
				if(nextPosition == -1) {
					nextPositive = false;
				} else {
					nextPosition = position;
				}
				ret = getSet(params, nextPosition, nextPositive, nextPositiveSum, nextNegativeSum);
			} else {
				int maxNumber = map.get(offset / Math.abs(params[position]));
				if(maxNumber < i) {
					break;
				}
				nextNegativeSum += value;
				ret = getSet(params, position, false, nextPositiveSum, nextNegativeSum);
			}
			sum += ret;
		}
		return sum;
	}
	
	private static int nextNum(int[] params, int start, boolean isPositive) {
		int ret = -1;
		for (int i = start + 1; i < 4; i++) {
			if((params[i] > 0) == isPositive) {
				return i;
			}
		}
		return ret;
	}

}
