package michael.slf4j.learning.hdu;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class C1235 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				Map<Integer, Integer> map = new TreeMap<>();
				for (int i = 0; i < n; i++) {
					int score = sc.nextInt();
					Integer count = map.get(score);
					if(count == null) {
						count = 0;
					}
					count++;
					map.put(score, count);
				}
				Integer count = map.get(sc.nextInt());
				if(count == null) {
					count = 0;
				}
				System.out.println(count);
			}
		}
	}

}
