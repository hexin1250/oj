package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1170_BalloonComes {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int t = sc.nextInt();
			sc.nextLine();
			while(t-- > 0) {
				String line = sc.nextLine();
				String[] parts = line.split("[\\s]+");
				char op = parts[0].charAt(0);
				int a = Integer.valueOf(parts[1]);
				int b = Integer.valueOf(parts[2]);
				if(op == '+') {
					System.out.println(a + b);
				} else if(op == '-') {
					System.out.println(a - b);
				} else if(op == '*') {
					System.out.println(a * b);
				} else {
					if(a % b == 0) {
						System.out.println(a / b);
					} else {
						double c = Double.valueOf(parts[1]);
						double d = Double.valueOf(parts[2]);
						System.out.printf("%.2f\r\n", c / d);
					}
				}
			}
		}
	}

}
