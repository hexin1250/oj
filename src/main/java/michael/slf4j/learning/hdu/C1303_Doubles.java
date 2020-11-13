package michael.slf4j.learning.hdu;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class C1303_Doubles {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int f = sc.nextInt();
				if(f == -1) {
					break;
				}
				Set<Integer> set = new TreeSet<>();
				int max = f;
				set.add(f);
				while((f = sc.nextInt()) != 0) {
					set.add(f);
					if(max < f) {
						max = f;
					}
				}
				int count = 0;
				for (int i : set) {
					if(2 * i > max) {
						break;
					}
					if(set.contains(2 * i)) {
						count++;
					}
				}
				System.out.println(count);
			}
		}
	}

}
