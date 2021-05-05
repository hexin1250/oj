package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class T1494 {

	public static void main(String[] args) {
		Random r = new Random();
		int count = 100;
		while(count-- > 0) {
			int n = r.nextInt(99) + 1;
			int cycle = r.nextInt(99) + 1;
			int[] normal = new int[n];
			int[] fast = new int[n];
			for (int i = 0; i < n; i++) {
				normal[i] = r.nextInt(100) + 1;
				fast[i] = r.nextInt(normal[i]);
			}
			System.out.println(n + " " + cycle);
			System.out.println(Arrays.stream(normal).mapToObj(i -> new Integer(i).toString()).collect(Collectors.joining(" ")));
			System.out.println(Arrays.stream(fast).mapToObj(i -> new Integer(i).toString()).collect(Collectors.joining(" ")));
			System.out.println("Result:" + C1494.getDp(n, cycle, normal, fast));
		}
	}

}
