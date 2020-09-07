package michael.slf4j.learning;

import java.util.Scanner;

public class C2003_Abs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			double d = sc.nextDouble();
			System.out.printf("%.2f\r\n", Math.abs(d));
		}
		sc.close();
	}

}
