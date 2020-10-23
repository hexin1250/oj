package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1202_GPA {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				int n = sc.nextInt();
				int sumScore = 0;
				int sumPoint = 0;
				for (int i = 0; i < n; i++) {
					int score = sc.nextInt();
					int result = sc.nextInt();
					if(result == -1) {
						continue;
					}
					int value = 0;
					if(result >= 90) {
						value = 4;
					} else if(result >= 80) {
						value = 3;
					} else if(result >= 70) {
						value = 2;
					} else if(result >= 60) {
						value = 1;
					}
					sumScore += score;
					sumPoint += score * value;
				}
				if(sumScore == 0) {
					System.out.println(-1);
				} else {
					double ret = ((double)sumPoint) / ((double)sumScore);
					System.out.printf("%.2f\r\n", ret);
				}
			}
		}
	}

}
