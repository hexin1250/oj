package michael.slf4j.learning.hdu;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class C1412 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				Set<Integer> set = new TreeSet<>();
				for (int i = 0; i < n; i++) {
					set.add(sc.nextInt());
				}
				for (int i = 0; i < m; i++) {
					set.add(sc.nextInt());
				}
				System.out.println(set.stream().map(i -> i.toString()).collect(Collectors.joining(" ")));
			}
		}
	}

}
