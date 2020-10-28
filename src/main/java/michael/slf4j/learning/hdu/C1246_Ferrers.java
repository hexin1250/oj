package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class C1246_Ferrers {
	public static Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
	public static int[] mem = new int[301];
	
	static {
		Map<Integer, Integer> map1 = new HashMap<>();
		map1.put(1, 1);
		map.put(1, map1);
		map.put(2, new HashMap<>());
		
		for (int i = 1; i <= 300; i++) {
			mem[i] = getCount(i, 400);
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				System.out.println(mem[n]);
			}
		}
	}
	
	public static int getCount(int n, int max) {
		if(n == 0) {
			return 1;
		}
		Map<Integer, Integer> resultMap = map.get(n);
		int sum = 0;
		if(resultMap != null) {
			for (Entry<Integer, Integer> entry : resultMap.entrySet()) {
				int l = entry.getKey();
				if(l <= max) {
					sum += entry.getValue();
				}
			}
			return sum;
		}
		resultMap = new HashMap<>();
		int currentMax = getMax(n);
		int maxLength = currentMax > max ? max : currentMax;
		for (int i = maxLength; i >= 1; i--) {
			if(n + 1 - 2 * i > (i - 1) * (i - 1)) {
				break;
			}
			int currentCount = getCount(n + 1 - 2 * i, i - 1);
			if(currentCount > 0) {
				resultMap.put(i, currentCount);
				sum += currentCount;
			}
		}
		map.put(n, resultMap);
		return sum;
	}
	
	public static int getMax(int n) {
		if(n % 2 == 0) {
			return n / 2;
		}
		return (n + 1) / 2;
	}

}
