package michael.slf4j.learning;

import java.util.Arrays;
import java.util.Scanner;

public class C1042_N {
	private static final int BIT = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			print(n);
		}
		sc.close();
	}
	
	public static void print(int n) {
		if(n == 0 || n == 1) {
			System.out.println(1);
		} else {
			int[] ret = multiplyResult(n);
			boolean start = true;
			StringBuffer sb = new StringBuffer();
			for (int i = ret.length - 1; i >= 0; i--) {
				if(start && ret[i] == 0) {
					continue;
				} else {
					start = false;
				}
				sb.append(ret[i]);
			}
			System.out.println(sb.toString());
		}
	}
	
	private static int[] multiplyResult(int n) {
		int length = n % 2 == 0 ? n / 2 : n / 2 + 1;
		int[][] arr = new int[length][];
		for (int i = 1; i <= length; i++) {
			if(i != n - i + 1) {
				arr[i - 1] = multiply(i, (n - i) + 1);
			} else {
				arr[i - 1] = multiply(i, 1);
			}
		}
		while(arr.length > 1) {
			int l = arr.length % 2 == 0 ? arr.length / 2 : arr.length / 2 + 1;
			int[][] tmpArr = new int[l][];
			for (int i = 0; i < l; i++) {
				if(i != arr.length - 1 - i) {
					tmpArr[i] = multiply(arr[i], arr[arr.length - 1 - i]);
				} else {
					tmpArr[i] = arr[i];
				}
			}
			arr = tmpArr;
		}
		return arr[0];
	}
	
	private static int[] multiply(int a, int b) {
		return multiply(nOfArray(a), nOfArray(b));
	}

	private static int[] multiply(int[] a, int[] b) {
		int[] ret = new int[a.length + b.length];
		for (int i = 0; i < a.length; i+=BIT) {
			int numberI = getNumber(a, i, BIT);
			for (int j = 0; j < b.length; j+=BIT) {
				int numberJ = getNumber(b, j, BIT);
				ret[i + j] += numberI * numberJ;
			}
		}
		for (int i = 0; i < a.length + b.length - 1; i++) {
			if(ret[i] / 10 > 0) {
				ret[i + 1] += ret[i] / 10;
				ret[i] = ret[i] % 10;
			}
		}
		return ret;
	}

	private static int getNumber(int[] a, int start, int bit) {
		int sum = 0;
		int initP = (start + bit) > a.length ? a.length : (start + bit);
		for (int i = initP - 1; i >= start; i--) {
			sum *= 10;
			sum += a[i];
		}
		return sum;
	}
	
	private static int[] nOfArray(int a) {
		int index = 0;
		int[] a1 = new int[6];
		while(a / 10 > 0) {
			if(a / 10 > 0) {
				a1[index] = a % 10;
				a = a / 10;
			}
			index++;
		}
		a1[index++] = a;
		return Arrays.copyOf(a1, index);
	}

}
