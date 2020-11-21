package michael.slf4j.learning.hdu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C1342_Lotto {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean start = false;
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				if(start) {
					System.out.println();
				} else {
					start = true;
				}
				int[] a = new int[n];
				for (int i = 0; i < n; i++) {
					a[i] = sc.nextInt();
				}
				Arrays.sort(a);
				dfs(a, new int[6], 0, 0);
			}
		}
	}

	private static void dfs(int[] a, int[] ret, int step, int index) {
		if(step == 6) {
			System.out.println(Arrays.stream(ret).mapToObj(i -> i + "").collect(Collectors.joining(" ")));
			return;
		}
		for (int j = index; j < a.length - (5 - step); j++) {
			ret[step] = a[j];
			dfs(a, ret, step + 1, j + 1);
		}
	}

}
