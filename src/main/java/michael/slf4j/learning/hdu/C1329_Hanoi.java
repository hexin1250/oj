package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1329_Hanoi {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				int n = sc.nextInt();
				int[] a = new int[n];
				int index = 0;
				while(true) {
					index++;
					boolean quit = true;
					for (int i = 1; i <= n; i++) {
						if(a[i - 1] == 0) {
							a[i - 1] = index;
							quit = false;
							break;
						}
						int sum = a[i - 1] + index;
						int sqrt = (int)(Math.sqrt(sum));
						if(sum == sqrt * sqrt) {
							a[i - 1] = index;
							quit = false;
							break;
						}
					}
					if(quit) {
						break;
					}
				}
				System.out.println(index - 1);
			}
		}
	}

}
