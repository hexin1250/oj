package michael.slf4j.learning.hdu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class C1323_Perfection {
	private static Set<Integer> perfect = new HashSet<>();
	
	static {
		perfect.add(1);
		perfect.add(6);
		perfect.add(28);
		perfect.add(496);
		perfect.add(8128);
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("PERFECTION OUTPUT");
			while (sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				StringBuffer sb = new StringBuffer();
				String part = n + "";
				for (int i = 0; i < 5 - part.length(); i++) {
					sb.append(' ');
				}
				sb.append(n).append("  ");
				if(perfect.contains(n)) {
					sb.append("PERFECT");
				} else {
					int mid = n / 2;
					List<Integer> list = new ArrayList<>();
					int sum = 0;
					for (int i = 1; i <= mid; i++) {
						if(n % i == 0) {
							list.add(i);
							sum += i;
						}
					}
					if(sum < n) {
						sb.append("DEFICIENT");
					} else {
						boolean find = false;
						for (int p : perfect) {
							if(n % p == 0) {
								find = true;
								break;
							}
						}
						if(find) {
							sb.append("ABUNDANT");
						} else {
							sb.append("DEFICIENT");
						}
					}
				}
				System.out.println(sb.toString());
			}
			System.out.println("END OF OUTPUT");
		}
	}

}
