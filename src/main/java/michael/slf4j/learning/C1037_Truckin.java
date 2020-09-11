package michael.slf4j.learning;

import java.util.Scanner;

public class C1037_Truckin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int[] arr = new int[3];
			int crash = -1;
			for (int i = 0; i < 3; i++) {
				arr[i] = sc.nextInt();
				if(arr[i] <= 168 && crash == -1) {
					crash = arr[i];
				}
			}
			if(crash == -1) {
				System.out.println("NO CRASH");
			} else {
				System.out.printf("CRASH %d\r\n", crash);
			}
		}
		sc.close();
	}

}
