package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class C1563 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				Set<Integer> duplicated = new HashSet<>();
				Set<Integer> check = new HashSet<>();
				for (int i = 0; i < n; i++) {
					int v = sc.nextInt();
					if(!duplicated.contains(v)) {
						if(check.contains(v)) {
							check.remove(v);
							duplicated.add(v);
						} else {
							check.add(v);
						}
					}
				}
				System.out.println(check.stream().map(i -> i.toString()).collect(Collectors.joining(",")));
			}
		}
	}

}
