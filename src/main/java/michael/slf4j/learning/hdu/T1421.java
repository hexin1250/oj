package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class T1421 {

	public static void main(String[] args) {
		Random r = new Random();
		int count = 1000;
		while(count-- > 0) {
			int n = r.nextInt(20) + 2;
			int k = r.nextInt(n / 2) + 1;
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = r.nextInt(2 << 15) + 1;
			}
			Arrays.sort(arr);
			long actual = C1421.getResult(arr, n, k);
			int expect = AC1421.getResult(arr, n, k);
			if(actual != expect) {
				System.out.println(n + " " + k);
				System.out.println(Arrays.stream(arr).mapToObj(i -> i + "").collect(Collectors.joining(" ")));
				System.out.println(actual + ":" + expect);
				break;
			}
		}
	}

}
