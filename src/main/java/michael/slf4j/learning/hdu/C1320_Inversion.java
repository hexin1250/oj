package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C1320_Inversion {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				String option = sc.next();
				int[] ret = new int[n];
				if("P".equals(option)) {
					int[] a = new int[n];
					for (int i = 0; i < n; i++) {
						a[i] = sc.nextInt();
						int sum = 0;
						for (int j = 0; j < i; j++) {
							if(a[j] > a[i]) {
								sum++;
							}
						}
						ret[a[i] - 1] = sum;
					}
				} else {
					for (int i = 0; i < n; i++) {
						int currentValue = sc.nextInt();
						int sum = 0;
						for (int j = 0; j < n; j++) {
							if(ret[j] != 0) {
								continue;
							}
							if(sum == currentValue) {
								ret[j] = i + 1;
								break;
							}
							sum++;
						}
					}
				}
				System.out.println(Arrays.stream(ret).mapToObj(i -> i + "").collect(Collectors.joining(" ")));
			}
		}
	}

}
