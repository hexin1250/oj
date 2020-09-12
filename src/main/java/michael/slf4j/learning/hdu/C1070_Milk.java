package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1070_Milk {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int testcase = 0; testcase < t; testcase++) {
			int n = sc.nextInt();
			sc.nextLine();
			int minPrice = Integer.MAX_VALUE;
			int maxVol = -1;
			String brand = null;
			for (int i = 0; i < n; i++) {
				String line = sc.nextLine();
				String[] parts = line.split("[\\s]+");
				int price = Integer.valueOf(parts[1]);
				int vol = Integer.valueOf(parts[2]);
				int currentPrice = -1;
				if(vol >= 1000) {
					currentPrice = price * 24;
				} else if(vol < 200) {
					continue;
				} else {
					int days = vol / 200;
					currentPrice = price * 120 / days;
				}
				if(currentPrice < minPrice) {
					minPrice = currentPrice;
					maxVol = vol;
					brand = parts[0];
				} else if(currentPrice == minPrice) {
					if(maxVol < vol) {
						maxVol = vol;
						brand = parts[0];
					}
				}
			}
			System.out.println(brand);
		}
		sc.close();
	}

}
