package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C1262 {
	private static Set<Integer> set = new HashSet<>();
	
	static {
		set.add(1);
		set.add(3);
		set.add(5);
		for (int i = 6; i <= 10000; i++) {
			int mid = (int) Math.sqrt(i);
			boolean find = false;
			for (int j = 2; j <= mid; j++) {
				if(i % j == 0) {
					find = true;
					break;
				}
			}
			if(!find) {
				set.add(i);
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				int mid = n / 2;
				if(mid % 2 == 0) {
					mid = mid - 1;
				}
				for (int i = mid; i >= 1; i-=2) {
					int minus = n - i;
					if(set.contains(i) && set.contains(minus)) {
						System.out.println(i + " " + minus);
						break;
					}
				}
			}
		}
	}

}
