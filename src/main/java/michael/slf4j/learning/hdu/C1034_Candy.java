package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1034_Candy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int round = game(arr);
			System.out.println(round + " " + arr[0]);
		}
		sc.close();
	}

	private static int game(int[] arr) {
		int round = 0;
		int length = arr.length;
		while(!endGame(arr)) {
			round++;
			int[] given = new int[length];
			for (int i = 0; i < length; i++) {
				arr[i] = arr[i] / 2;
				if(i != length - 1) {
					given[i + 1] = arr[i];
				} else {
					given[0] = arr[i];
				}
			}
			for (int i = 0; i < length; i++) {
				arr[i] += given[i];
				if(arr[i] % 2 != 0) {
					arr[i]++;
				}
			}
		}
		return round;
	}

	private static boolean endGame(int[] arr) {
		int length = arr.length;
		for (int i = 1; i < length; i++) {
			if(arr[i - 1] != arr[i]) {
				return false;
			}
		}
		return true;
	}

}
