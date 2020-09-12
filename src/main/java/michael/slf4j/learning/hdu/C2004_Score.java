package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C2004_Score {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int score = sc.nextInt();
			if(score < 0 || score > 100) {
				System.out.println("Score is error!");
			} else if(score < 60) {
				System.out.println("E");
			} else if(score < 70) {
				System.out.println("D");
			} else if(score < 80) {
				System.out.println("C");
			} else if(score < 90) {
				System.out.println("B");
			} else {
				System.out.println("A");
			}
		}
		sc.close();
	}

}
