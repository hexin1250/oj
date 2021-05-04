package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1492_Divisors {
	private static final long[] FACTORS = new long[] {2L,3L,5L,7L};

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				long n = sc.nextLong();
				if(n == 0L) {
					break;
				}
				long[] times = new long[] {1L,1L,1L,1L};
				int index = 0;
				while(index < 4) {
					if(n % FACTORS[index] == 0){
						n = n / FACTORS[index];
						times[index] += 1;
					} else {
						index++;
					}
				}
				long sum = times[0] * times[1] * times[2] * times[3];
				System.out.println(sum);
			}
		}

	}

}
