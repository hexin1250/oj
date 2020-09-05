package michael.slf4j.learning;

import java.util.Arrays;
import java.util.Scanner;

public class AC1084_Grade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n == -1) {
				break;
			}
			sc.nextLine();
			String[] lines = new String[n];
			for (int i = 0; i < lines.length; i++) {
				lines[i] = sc.nextLine();
			}
			print(n, lines);
		}
		sc.close();
	}
	
	public static void print(int n, String[] lines) {
		String[] arr = new String[n];
		String[] str = new String[n];
		for (int i = 0; i < lines.length; i++) {
			String strs = lines[i];
			String strss[] = strs.split(" ");
			arr[i] = strss[0];
			str[i] = strss[1];
		}
		int[] arrs = new int[n];// t
		for (int i = 0; i < arr.length; i++) {
			String[] strss = str[i].split(":");
			arrs[i] = Integer.parseInt(strss[0]) * 3600 + Integer.parseInt(strss[1]) * 60
					+ Integer.parseInt(strss[2]);
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("5")) {// 加双引号
				System.out.println("100");
			} else if (arr[i].equals("4")) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[j].equals("4")) {
						sum++;
					}
				}
				if (sum == 1) {
					System.out.println("95");
				} else {
					int tt = 0;
					int[] t = new int[sum];
					for (int j = 0; j < arr.length; j++) {
						if (arr[j].equals("4")) {
							t[tt] = arrs[j];
							tt++;
						}
					}
					Arrays.sort(t);
					for (int j = 0; j < t.length; j++) {
						if (arrs[i] == t[j]) {
							if ((j + 1) <= (sum / 2)) {
								System.out.println("95");
							} else {
								System.out.println("90");
							}
						}
					}
					sum = 0;
				}
			} else if (arr[i].equals("3")) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[j].equals("3")) {
						sum++;
					}
				}
				if (sum == 1) {
					System.out.println("85");
				} else {
					int tt = 0;
					int[] t = new int[sum];
					for (int j = 0; j < arr.length; j++) {
						if (arr[j].equals("3")) {
							t[tt] = arrs[j];
							tt++;
						}
					}
					Arrays.sort(t);
					for (int j = 0; j < t.length; j++) {
						if (arrs[i] == t[j]) {
							if ((j + 1) <= (sum / 2)) {
								System.out.println("85");
							} else {
								System.out.println("80");
							}
						}
					}
					sum = 0;
				}
			} else if (arr[i].equals("2")) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[j].equals("2")) {
						sum++;
					}
				}
				if (sum == 1) {
					System.out.println("75");
				} else {
					int tt = 0;
					int[] t = new int[sum];
					for (int j = 0; j < arr.length; j++) {
						if (arr[j].equals("2")) {
							t[tt] = arrs[j];
							tt++;
						}
					}
					Arrays.sort(t);
					for (int j = 0; j < t.length; j++) {
						if (arrs[i] == t[j]) {
							if ((j + 1) <= (sum / 2)) {
								System.out.println("75");
							} else {
								System.out.println("70");
							}
						}
					}
					sum = 0;
				}
			} else if (arr[i].equals("1")) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[j].equals("1")) {
						sum++;
					}
				}
				if (sum == 1) {
					System.out.println("65");
				} else {
					int tt = 0;
					int[] t = new int[sum];
					for (int j = 0; j < arr.length; j++) {
						if (arr[j].equals("1")) {
							t[tt] = arrs[j];
							tt++;
						}
					}
					Arrays.sort(t);
					for (int j = 0; j < t.length; j++) {
						if (arrs[i] == t[j]) {
							if ((j + 1) <= (sum / 2)) {
								System.out.println("65");
							} else {
								System.out.println("60");
							}
						}
					}
					sum = 0;
				}
			} else if (arr[i].equals("0")) {
				System.out.println("50");
			}

		}
		System.out.println();
		
	}
}