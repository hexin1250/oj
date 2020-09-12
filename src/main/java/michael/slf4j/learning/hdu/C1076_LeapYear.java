package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1076_LeapYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int y = sc.nextInt();
			int a = sc.nextInt();
			System.out.println(getYear(y, a));
		}
		sc.close();
	}
	
	public static int getYear(int year, int times) {
		int ac = times;
		int ay = year;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			ay = year;
		} else {
			while(!((ay % 4 == 0 && ay % 100 != 0) || ay % 400 == 0)) {
				ay += 1;
			}
		}
		ac--;
		ay += (ac / 97) * 400;
		ac = ac % 97;
		while(ac > 0) {
			ay += 4;
			if((ay % 4 == 0 && ay % 100 != 0) || ay % 400 == 0) {
				ac--;
			}
		}
		return ay;
	}

}
