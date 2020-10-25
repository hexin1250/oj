package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1231 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) {
					break;
				}
				int start = 0;
				int end = 0;
				int preS = 0;
				int preE = 0;
				int sum = 0;
				int max = Integer.MIN_VALUE;
				
				int negetive = 0;
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					int number = sc.nextInt();
					arr[i] = number;
					if(number < 0) {
						negetive++;
					}
					sum += number;
					if(sum < 0) {
						sum = 0;
						start = i + 1;
						end = i + 1;
					} else if(sum > max) {
						max = sum;
						end = i;
						preS = start;
						preE = end;
					}
				}
				if(negetive == n) {
					System.out.println(0 + " " + arr[0] + " " + arr[n - 1]);
				} else {
					System.out.println(max + " " + arr[preS] + " " + arr[preE]);
				}
			}
		}
	}

}
