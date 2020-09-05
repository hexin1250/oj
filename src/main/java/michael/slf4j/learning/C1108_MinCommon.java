package michael.slf4j.learning;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class C1108_MinCommon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] parts = line.split("[\\s]+");
			Map<Integer, Integer> finalMap = new HashMap<>();
			for (int i = 0; i < parts.length; i++) {
				int tmp = Integer.valueOf(parts[i]);
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
			int sum = 1;
			for (Entry<Integer, Integer> entry : finalMap.entrySet()) {
				int number = entry.getKey();
				int times = entry.getValue();
				for (int i = 0; i < times; i++) {
					sum *= number;
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}

}