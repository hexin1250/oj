package michael.slf4j.learning.hdu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C1264_CountingSquares {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Set<Integer> set = new HashSet<>();
			while(sc.hasNext()) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				int d = sc.nextInt();
				if(a <= -1 && b <= -1 && c <= -1 && d <= -1) {
					System.out.println(set.size());
					set.clear();
					if(a == -2 && b == -2 && c == -2 && d == -2) {
						break;
					}
					continue;
				}
				int xMin = Math.min(a, c);
				int xMax = Math.max(a, c);
				int yMin = Math.min(b, d);
				int yMax = Math.max(b, d);
				for (int i = xMin; i < xMax; i++) {
					for (int j = yMin; j < yMax; j++) {
						set.add(i * 1000 + j);
					}
				}
			}
		}
	}

}
